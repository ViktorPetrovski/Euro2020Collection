package com.euro.sticker.gallery.data

import androidx.room.*
import com.euro.sticker.gallery.data.model.AlbumEntity
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

    @Insert
    suspend fun insertCategory(vararg categoryEntity: CategoryEntity)

    @Insert
    suspend fun insertStickers(vararg stickers: StickerEntity)

    @Query("SELECT * FROM AlbumEntity")
    suspend fun getAllAlbums(): List<AlbumEntity>
}
