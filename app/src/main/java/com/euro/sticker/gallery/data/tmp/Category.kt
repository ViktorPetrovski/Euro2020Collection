package com.euro.sticker.gallery.data.tmp

data class Category(
    val name: String,
    val stickersCount: Int,
    val position: Int,
    val stickers: List<Sticker>
)