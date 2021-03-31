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
                        categoryContent
                    )
                }
                resultData.add(categoryContent)
                resultData.addAll(stickersContent)
            }
            stickers.postValue(resultData)
        }
    }
}