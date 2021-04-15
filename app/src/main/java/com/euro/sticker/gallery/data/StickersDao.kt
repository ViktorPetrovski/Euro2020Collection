package com.euro.sticker.gallery.data

import androidx.room.*
import com.euro.sticker.gallery.data.model.*

@Dao
interface StickersDao {

    @Transaction
    @Query("SELECT * FROM CategoryEntity")
    suspend fun getCategoriesAndStickers(): List<StickersAndCategories>

    @Query("SELECT * FROM StickerEntity")
    suspend fun getAllStickers(): List<StickerEntity>

    @Query("UPDATE StickerEntity SET amount=:amount WHERE uid=:uid")
    suspend fun updateSticker(amount: Int, uid: Int)

    @Query("UPDATE StickerEntity SET number=:number WHERE uid=:uid")
    suspend fun updateStickerNumber(uid: Long, number: Int)

    @Insert
    suspend fun insertCategory(vararg categoryEntity: CategoryEntity)

    @Insert
    suspend fun insertStickers(vararg stickers: StickerEntity)

    @Query("SELECT * FROM AlbumEntity")
    suspend fun getAllAlbums(): List<AlbumEntity>

    @Query("SELECT COUNT(number) from StickerEntity WHERE amount > 0 group by album_id")
    suspend fun getAlbumsWithTotalCount(): List<Int>
}
