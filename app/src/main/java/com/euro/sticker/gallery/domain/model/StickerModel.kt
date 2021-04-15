package com.euro.sticker.gallery.domain.model

import com.euro.sticker.gallery.data.model.StickerEntity

data class StickerModel(
    val uid: Int,
    val number: Int,
    val name: String,
    val amountOwned: Int,
    val albumId: Int
) {
    constructor(stickerEntity: StickerEntity) : this(
        stickerEntity.uid.toInt(),
        stickerEntity.number,
        stickerEntity.name,
        stickerEntity.amount,
        stickerEntity.albumId.toInt()
    )
}