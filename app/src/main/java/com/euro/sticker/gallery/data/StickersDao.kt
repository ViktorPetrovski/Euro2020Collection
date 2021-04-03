package com.euro.sticker.gallery.data

import androidx.room.*
import com.euro.sticker.gallery.data.model.CategoryEntity
import com.euro.sticker.gallery.data.model.StickerEntity
import com.euro.sticker.gallery.data.model.StickersAndCategories

@Dao
interface StickersDao {

    @Transaction
    @Query("SELECT * FROM CategoryEntity")
    suspend fun getCategoriesAndStickers(): List<StickersAndCategories>

    @Query("SELECT * FROM StickerEntity")
    suspend fun getAllStickers(): List<StickerEntity>

    @Query("UPDATE StickerEntity SET amount=:amount WHERE number=:number")
    suspend fun updateSticker(amount: Int, number: Int)

    @Query("UPDATE StickerEntity SET number=:number WHERE uid=:uid")
    suspend fun updateStickerNumber(uid: Long, number: Int)
}
