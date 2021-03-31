package com.euro.sticker.gallery.domain.model

import com.euro.sticker.gallery.data.model.StickerEntity

data class StickerModel(
        val number: Int,
        val name: String,
        val amountOwned: Int
) {
    constructor(stickerEntity: StickerEntity) : this(
            stickerEntity.number,
            stickerEntity.name,
            stickerEntity.amount
    )
}