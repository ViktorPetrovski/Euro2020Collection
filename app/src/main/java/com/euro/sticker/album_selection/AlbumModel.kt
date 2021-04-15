package com.euro.sticker.album_selection

data class AlbumModel(
    val name: String,
    val collectedStickers: Int,
    val stickersCount: Int,
    val albumId: Int,
    val isSelected: Boolean = false
)
