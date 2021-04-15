package com.euro.sticker.gallery.ui.model

import com.euro.sticker.gallery.domain.model.CategoryModel
import com.euro.sticker.gallery.domain.model.StickerModel

sealed class GalleryContent(val id: String, val contentType: ContentType)

data class CategoryContent(
    val categoryName: String,
    val totalStickersInCategory: Int,
    val collectedStickers: Int
) : GalleryContent(categoryName, ContentType.HEADER) {

    constructor(categoryModel: CategoryModel) : this(
        categoryName = categoryModel.name,
        totalStickersInCategory = categoryModel.stickers.size,
        collectedStickers = categoryModel.stickers.filter { it.amountOwned > 0 }.size
    )

}

data class StickerContent(
    val uid: Int,
    val number: Int,
    val name: String,
    val amount: Int,
    val categoryName: String
) : GalleryContent(number.toString(), ContentType.STICKER) {

    constructor(stickerModel: StickerModel, categoryName: String) : this(
        uid = stickerModel.uid,
        number = stickerModel.number,
        name = stickerModel.name,
        amount = stickerModel.amountOwned,
        categoryName = categoryName
    )
}