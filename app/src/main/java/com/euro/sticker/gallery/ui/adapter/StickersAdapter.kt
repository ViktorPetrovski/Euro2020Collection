package com.euro.sticker.gallery.ui.adapter

import android.view.ViewGroup
import com.euro.sticker.gallery.ui.model.ContentType
import com.euro.sticker.gallery.ui.model.GalleryContent
import com.euro.sticker.gallery.ui.adapter.view_holders.CategoryViewHolder
import com.euro.sticker.gallery.ui.adapter.view_holders.StickerViewHolder
import com.euro.sticker.gallery.ui.model.StickerContent
import com.euro.sticker.uicommon.base.recyclerview.BaseAdapter
import com.euro.sticker.uicommon.base.recyclerview.BaseViewHolder

class StickersAdapter(private val itemClicked: (item: StickerContent) -> Unit) : BaseAdapter<GalleryContent>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*, GalleryContent> {
        return when (ContentType.getTypeFromAdapterTypeId(viewType)) {
            ContentType.HEADER -> CategoryViewHolder.buildVIewHolder(parent)
            ContentType.STICKER -> StickerViewHolder.buildVIewHolder(parent, itemClicked)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = itemList[position]
        return item.contentType.adapterTypeId
    }
}
