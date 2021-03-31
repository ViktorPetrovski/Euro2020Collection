package com.euro.sticker.gallery.domain.model

import com.euro.sticker.gallery.data.model.StickersAndCategories

data class CategoryModel(
        val name: String,
        val stickers: List<StickerModel>
) {
    constructor(stickersAndCategories: StickersAndCategories) : this(
            stickersAndCategories.categoryEntity.name,
            stickersAndCategories.stickers.map { StickerModel(it) }
    )
}
