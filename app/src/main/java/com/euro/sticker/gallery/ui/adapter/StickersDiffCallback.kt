package com.euro.sticker.gallery.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.euro.sticker.gallery.ui.model.CategoryContent
import com.euro.sticker.gallery.ui.model.GalleryContent
import com.euro.sticker.gallery.ui.model.StickerContent

class StickersDiffCallback(
    private val oldList: List<GalleryContent>,
    private val newList: List<GalleryContent>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return if (oldItem is CategoryContent && newItem is CategoryContent) {
            return oldItem == newItem
        } else if (oldItem is StickerContent && newItem is StickerContent) {
            return oldItem == newItem
        } else
            false
    }
}