package com.euro.sticker.gallery.data

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.euro.sticker.album_selection.AlbumModel
import com.euro.sticker.gallery.domain.model.CategoryModel
import com.euro.sticker.gallery.domain.model.ViewFilter
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import javax.inject.Inject

class Repository @Inject constructor(
    private val stickersDao: StickersDao,
    private val mySharedPreferences: MySharedPreferences,
    @ApplicationContext private val context: Context
) {

    suspend fun getAllStickers(): List<CategoryModel> {
        val selectedAlbumId = mySharedPreferences.getSelectedAlbum()
        if (selectedAlbumId == -1) {
            return emptyList()
        }
        return stickersDao.getCategoriesAndStickers().map { CategoryModel(it, selectedAlbumId) }
    }

    suspend fun updateSticker(newAmount: Int, uid: Int) = stickersDao.updateSticker(
        newAmount,
        uid
    )

    fun getFilter(): ViewFilter = mySharedPreferences.get()

    fun changeFilter(setFilter: ViewFilter) = mySharedPreferences.setStoredTag(setFilter)

    fun isAlbumSelected() = mySharedPreferences.getSelectedAlbum() != -1

    fun changeSelectedAlbum(albumId: Int) = mySharedPreferences.changeSelectedAlbum(albumId)

    suspend fun getAllAlbums(): List<AlbumModel> {
        val albums = mutableListOf<AlbumModel>()
        val selectedAlbum = mySharedPreferences.getSelectedAlbum()
        val count = stickersDao.getAlbumsWithTotalCount()
        stickersDao.getAllAlbums().forEachIndexed { index, albumEntity ->
            albums.add(
                AlbumModel(
                    albumEntity.name,
                    count[index],
                    albumEntity.stickersCount,
                    albumEntity.id.toInt(),
                    albumEntity.id.toInt() == selectedAlbum
                )
            )
        }
        return albums
    }
}