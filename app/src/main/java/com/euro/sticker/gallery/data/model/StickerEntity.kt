package com.euro.sticker.gallery.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StickerEntity(
    @PrimaryKey(autoGenerate = true) val uid: Long = 0L,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "number") val number: Int,
    @ColumnInfo(name = "amount") val amount: Int = 0,
    @ColumnInfo(name = "category_id") val categoryId: Long
)
