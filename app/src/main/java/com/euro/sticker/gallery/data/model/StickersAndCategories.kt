package com.euro.sticker.gallery.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class StickersAndCategories(
    @Embedded val categoryEntity: CategoryEntity,
    @Relation(
        parentColumn = "uid",
        entityColumn = "category_id"
    )
    val stickers: List<StickerEntity>
)