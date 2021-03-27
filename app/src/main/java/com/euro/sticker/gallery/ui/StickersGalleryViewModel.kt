package com.euro.sticker.gallery.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class StickersGalleryViewModel : ViewModel() {

    private val stickers = MutableLiveData<List<Int>>()

    init {
        val list = mutableListOf<Int>()
        repeat(600) {
            list.add(it)
        }
        stickers.postValue(list)
    }
}