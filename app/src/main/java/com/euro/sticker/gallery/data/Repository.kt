package com.euro.sticker.gallery.data

import com.euro.sticker.album_selection.AlbumModel
import com.euro.sticker.gallery.domain.model.CategoryModel
import com.euro.sticker.gallery.domain.model.ViewFilter
import javax.inject.Inject

private const val PREDEFINED_ALBUM_COUNT = 25
private const val DEFAULT_ALBUM_ID = 1

class Repository @Inject constructor(
    private val stickersDao: StickersDao,
    private val mySharedPreferences: MySharedPreferences
) {

    suspend fun getAllStickers(): List<CategoryModel> {
        val selectedAlbumId = mySharedPreferences.getSelectedAlbum()
        if (selectedAlbumId == -1) {
            return emptyList()
        }
        return stickersDao.getCategoriesAndStickers().map { CategoryModel(it, selectedAlbumId) }
            .filter { it.stickers.isNotEmpty() }
    }

    suspend fun updateSticker(newAmount: Int, uid: Int) = stickersDao.updateSticker(newAmount, uid)

    fun getFilter(): ViewFilter = mySharedPreferences.get()

    fun changeFilter(setFilter: ViewFilter) = mySharedPreferences.setStoredTag(setFilter)

    suspend fun isAlbumSelected() : Boolean {
        val selectedAlbum = mySharedPreferences.getSelectedAlbum() != -1
        if (selectedAlbum)
            return true
        // Count of first album
        val count = stickersDao.getAlbumsWithTotalCount().firstOrNull() ?: return false
        if (count > PREDEFINED_ALBUM_COUNT)
            mySharedPreferences.changeSelectedAlbum(DEFAULT_ALBUM_ID)
        return true
    }

    fun changeSelectedAlbum(albumId: Int) = mySharedPreferences.changeSelectedAlbum(albumId)

    suspend fun getAllAlbums(): List<AlbumModel> {
        val albums = mutableListOf<AlbumModel>()
        val selectedAlbum = mySharedPreferences.getSelectedAlbum()
        val albumsWithCount = stickersDao.getAlbumsWithTotalCount()
        stickersDao.getAllAlbums().forEachIndexed { index, albumEntity ->
            val albumCount = albumsWithCount.getOrNull(index) ?: 0
            albums.add(
                AlbumModel(
                    albumEntity.name,
                    albumCount,
                    albumEntity.stickersCount,
                    albumEntity.id.toInt(),
                    albumEntity.id.toInt() == selectedAlbum
                )
            )
        }
        return albums
    }
}