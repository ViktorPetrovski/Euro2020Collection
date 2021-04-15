package com.euro.sticker.album_selection

import android.view.ViewGroup
import com.euro.sticker.uicommon.base.recyclerview.BaseAdapter
import com.euro.sticker.uicommon.base.recyclerview.BaseViewHolder

class AlbumAdapter(private val itemClicked: (item: AlbumModel) -> Unit) :
    BaseAdapter<AlbumModel>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*, AlbumModel> {
        return SelectAlbumViewHolder.buildViewHolder(parent, itemClicked)
    }
}