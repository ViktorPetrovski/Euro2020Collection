package com.euro.sticker.gallery.data

import android.content.Context
import android.preference.PreferenceManager
import com.euro.sticker.gallery.domain.model.ViewFilter
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

private const val VIEW_FILTER_ORDINAL = "com.euro.sticker.gallery.data.VIEW_FILTER"
private const val SELECTED_ALBUM = "com.euro.sticker.gallery.data.SELECTED_ALBUM"

@Singleton
class MySharedPreferences @Inject constructor(@ApplicationContext context: Context) {
    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    fun get(): ViewFilter {
        val filter =  prefs.getInt(VIEW_FILTER_ORDINAL, 0)
        return ViewFilter.values()[filter]
    }

    fun setStoredTag(viewFilter: ViewFilter) {
        prefs.edit().putInt(VIEW_FILTER_ORDINAL, viewFilter.ordinal).apply()
    }


    fun getSelectedAlbum(): Int {
        return prefs.getInt(SELECTED_ALBUM, -1)
    }

    fun changeSelectedAlbum(albumId: Int) {
        prefs.edit().putInt(SELECTED_ALBUM, albumId).apply()
    }
}