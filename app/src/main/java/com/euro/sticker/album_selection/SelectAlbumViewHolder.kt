package com.euro.sticker.album_selection

import android.view.LayoutInflater
import android.view.ViewGroup
import com.euro.sticker.databinding.ViewSelectAlbumBinding
import com.euro.sticker.uicommon.base.recyclerview.BaseViewHolder

class SelectAlbumViewHolder(
    private val itemBinding: ViewSelectAlbumBinding,
    private val albumClicked: (item: AlbumModel) -> Unit
) :
    BaseViewHolder<ViewSelectAlbumBinding, AlbumModel>(itemBinding) {

    override fun bind(item: AlbumModel) {
        itemBinding.albumName.text = item.name + "\n ${item.collectedStickers}/${item.stickersCount}"
        itemBinding.root.setOnClickListener { albumClicked.invoke(item) }
    }

    companion object {
        fun buildViewHolder(
            parent: ViewGroup,
            itemClicked: (item: AlbumModel) -> Unit
        ): SelectAlbumViewHolder {
            val bindings =
                ViewSelectAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return SelectAlbumViewHolder(bindings, itemClicked)
        }
    }
}
