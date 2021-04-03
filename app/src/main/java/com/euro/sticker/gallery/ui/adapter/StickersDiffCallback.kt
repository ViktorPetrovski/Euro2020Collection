package com.euro.sticker.gallery.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.euro.sticker.gallery.ui.adapter.content.CategoryContent
import com.euro.sticker.gallery.ui.adapter.content.GalleryContent
import com.euro.sticker.gallery.ui.adapter.content.StickerContent

class StickersDiffCallback(
    private val oldList: List<GalleryContent>,
    private val newList: List<GalleryContent>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        val isCategorySame =
            (oldItem as? CategoryContent)?.categoryName == (newItem as? CategoryContent)?.categoryName
        val isStickerSame =
            (oldItem as? StickerContent)?.number == (newItem as? StickerContent)?.number
        return isCategorySame || isStickerSame
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return if (oldItem is CategoryContent && newItem is CategoryContent) {
            return oldItem.collectedStickers == newItem.collectedStickers
        } else if (oldItem is StickerContent && newItem is StickerContent) {
            return oldItem.amount == newItem.amount
        } else
            false
    }
}