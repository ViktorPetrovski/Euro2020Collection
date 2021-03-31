package com.euro.sticker.gallery.ui.adapter.content

sealed class GalleryContent(val contentType: ContentType)

data class CategoryContent(
    val categoryName: String,
    val totalStickersInCategory: Int,
    val collectedStickers: Int
) : GalleryContent(ContentType.HEADER)

data class StickerContent(
    val number: Int,
    val name: String,
    val category: CategoryContent
) : GalleryContent(ContentType.STICKER)