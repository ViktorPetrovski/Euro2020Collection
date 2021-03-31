package com.euro.sticker.gallery.ui.adapter.content

import com.euro.sticker.gallery.domain.model.CategoryModel
import com.euro.sticker.gallery.domain.model.StickerModel

sealed class GalleryContent(val contentType: ContentType)

data class CategoryContent(
    val categoryName: String,
    val totalStickersInCategory: Int,
    val collectedStickers: Int
) : GalleryContent(ContentType.HEADER) {

    constructor(categoryModel: CategoryModel) : this(
        categoryName = categoryModel.name,
        totalStickersInCategory = categoryModel.stickers.size,
        collectedStickers = categoryModel.stickers.filter { it.amountOwned > 0 }.size
    )

}

data class StickerContent(
    val number: Int,
    val name: String,
    val amount: Int,
    val category: CategoryContent
) : GalleryContent(ContentType.STICKER) {

    constructor(stickerModel: StickerModel, category: CategoryContent) : this(
        number = stickerModel.number,
        name = stickerModel.name,
        amount = stickerModel.amountOwned,
        category = category
    )
}