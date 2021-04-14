package com.euro.sticker.gallery.data

import android.content.Context
import android.os.Build
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
        return stickersDao.getCategoriesAndStickers().map { CategoryModel(it) }
    }

    suspend fun updateSticker(newAmount: Int, number: Int) = stickersDao.updateSticker(
        newAmount,
        number
    )

    fun getFilter(): ViewFilter = mySharedPreferences.get()

    fun changeFilter(setFilter: ViewFilter) = mySharedPreferences.setStoredTag(setFilter)

    fun isAlbumSelected() = mySharedPreferences.getSelectedAlbum() != -1

    fun changeSelectedAlbum(albumId: Int) = mySharedPreferences.changeSelectedAlbum(albumId)

    suspend fun getAllAlbums(): List<AlbumModel> {
        val albums = mutableListOf<AlbumModel>()
        val selectedAlbum = mySharedPreferences.getSelectedAlbum()
        stickersDao.getAllAlbums().forEach {
            albums.add(
                AlbumModel(
                    it.name,
                    it.stickersCount,
                    it.id.toInt(),
                    it.id.toInt() == selectedAlbum
                )
            )
        }
        return albums
    }
}