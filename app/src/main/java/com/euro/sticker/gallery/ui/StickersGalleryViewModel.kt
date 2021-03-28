package com.euro.sticker.gallery.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

class StickersGalleryViewModel : ViewModel() {

    private val stickers = MutableLiveData<List<Int>>()
    val getStickers: LiveData<List<Int>> = stickers

    init {
        val list = mutableListOf<Int>()
        repeat(600) {
            list.add(it)
        }
        stickers.postValue(list)
    }
}