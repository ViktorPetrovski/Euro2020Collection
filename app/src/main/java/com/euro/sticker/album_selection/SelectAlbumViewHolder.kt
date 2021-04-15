package com.euro.sticker.album_selection

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.euro.sticker.R
import com.euro.sticker.databinding.ViewSelectAlbumBinding
import com.euro.sticker.uicommon.base.recyclerview.BaseViewHolder


class SelectAlbumViewHolder(
    private val context: Context,
    private val itemBinding: ViewSelectAlbumBinding,
    private val albumClicked: (item: AlbumModel) -> Unit
) :
    BaseViewHolder<ViewSelectAlbumBinding, AlbumModel>(itemBinding) {

    override fun bind(item: AlbumModel) {
        itemBinding.albumName.text = item.name
        itemBinding.albumStats.text = "${item.collectedStickers}/${item.stickersCount}"
        itemBinding.root.setOnClickListener { albumClicked.invoke(item) }
        itemBinding.root.backgroundTintList = ContextCompat.getColorStateList(
            context,
            getColorTint()
        )
        itemBinding.activeAlbum.isVisible = item.isSelected
    }

    private fun getColorTint() = when (adapterPosition) {
           0 -> R.color.blue_album_color
           1 -> R.color.orange_album_color
           2 -> R.color.perl_album_color
           else -> R.color.missing_sticker_bg
        }

    companion object {
        fun buildViewHolder(
            parent: ViewGroup,
            itemClicked: (item: AlbumModel) -> Unit
        ): SelectAlbumViewHolder {
            val bindings =
                ViewSelectAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return SelectAlbumViewHolder(parent.context, bindings, itemClicked)
        }
    }
}
