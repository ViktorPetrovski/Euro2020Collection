package com.euro.sticker.gallery.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.euro.sticker.gallery.data.Repository
import com.euro.sticker.gallery.domain.model.CategoryModel
import com.euro.sticker.gallery.domain.model.StickerModel
import com.euro.sticker.gallery.ui.adapter.content.CategoryContent
import com.euro.sticker.gallery.ui.adapter.content.GalleryContent
import com.euro.sticker.gallery.ui.adapter.content.StickerContent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StickersGalleryViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val stickers = MutableLiveData<List<GalleryContent>>()
    val getStickers: LiveData<List<GalleryContent>> = stickers

    private var stickersList = mutableListOf<GalleryContent>()

    init {
        fetchInitialData()
    }

    private fun fetchInitialData() {
        viewModelScope.launch {
            val resultData = mutableListOf<GalleryContent>()
            repository.getAllStickers().forEach {
                val categoryContent = CategoryContent(it)
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
            stickers.postValue(stickersList)
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
        }
        stickersList[indexOfItem] = galleryContent.copy(amount = newAmount)
        stickers.postValue(stickersList)
        viewModelScope.launch {
            repository.updateSticker(newAmount, galleryContent.number)
        }
    }
}