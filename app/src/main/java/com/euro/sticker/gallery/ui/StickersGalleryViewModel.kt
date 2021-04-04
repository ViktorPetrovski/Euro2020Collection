package com.euro.sticker.gallery.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.euro.sticker.gallery.data.Repository
import com.euro.sticker.gallery.ui.model.CategoryContent
import com.euro.sticker.gallery.ui.model.GalleryContent
import com.euro.sticker.gallery.ui.model.StickerContent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StickersGalleryViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val stickers = MutableLiveData<List<GalleryContent>>()
    val getStickers: LiveData<List<GalleryContent>> = stickers

    private var totalOwned: Int = 0
    private val stickersOwnedCount = MutableLiveData<Int>()
    val getOwnedStickersCount: LiveData<Int> = stickersOwnedCount

    private var stickersList = mutableListOf<GalleryContent>()
    private var selectedFilter = ViewFilter.All

    init {
        fetchInitialData()
    }

    private fun fetchInitialData() {
        viewModelScope.launch {
            val resultData = mutableListOf<GalleryContent>()
            repository.getAllStickers().forEach {
                val categoryContent = CategoryContent(it)
                totalOwned += categoryContent.collectedStickers
                val stickersContent = it.stickers.map { stickerModel ->
                    StickerContent(
                        stickerModel,
                        categoryContent.categoryName
                    )
                }
                resultData.add(categoryContent)
                resultData.addAll(stickersContent)
            }
            stickersList = resultData
            stickers.postValue(getDisplayList())
            stickersOwnedCount.postValue(totalOwned)
        }
    }

    fun addAmount(galleryContent: StickerContent) {
        var indexOfItem = -1
        var indexOfCategory = -1
        stickersList.forEachIndexed { index, item ->
            if (indexOfCategory != -1 && indexOfItem != -1)
                return@forEachIndexed
            else if (indexOfCategory == -1 && (item as? CategoryContent)?.categoryName == galleryContent.categoryName)
                indexOfCategory = index
            else if (indexOfItem == -1 && (item as? StickerContent)?.number == galleryContent.number)
                indexOfItem = index
        }
        val newAmount = galleryContent.amount + 1
        val category = stickersList[indexOfCategory] as CategoryContent
        if (newAmount == 1) {
            val updatedCategoryContent =
                category.copy(collectedStickers = category.collectedStickers + 1)
            stickersList[indexOfCategory] = updatedCategoryContent
            totalOwned++
            stickersOwnedCount.postValue(totalOwned)
        }
        stickersList[indexOfItem] = galleryContent.copy(amount = newAmount)
        stickers.postValue(getDisplayList())
        viewModelScope.launch {
            repository.updateSticker(newAmount, galleryContent.number)
        }
    }

    private fun getDisplayList(): List<GalleryContent> {
        stickersList =  when (selectedFilter) {
            ViewFilter.All -> stickersList
            ViewFilter.Missing -> stickersList.filterNot { (it as? StickerContent)?.amount ?: 0 > 0 }
            ViewFilter.Swaps -> stickersList.filterNot { (it as? StickerContent)?.amount ?: 0 <= 1 }
        }.toMutableList()
        return stickersList
    }

    fun changeFilter(filter: ViewFilter) {
        selectedFilter = filter
        stickers.postValue(getDisplayList())
    }

    enum class ViewFilter {
        All,
        Missing,
        Swaps
    }
}