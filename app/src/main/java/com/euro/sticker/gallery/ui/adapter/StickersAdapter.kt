package com.euro.sticker.gallery.ui.adapter

import android.view.ViewGroup
import com.euro.sticker.gallery.ui.adapter.content.ContentType
import com.euro.sticker.gallery.ui.adapter.content.GalleryContent
import com.euro.sticker.uicommon.base.recyclerview.BaseAdapter
import com.euro.sticker.uicommon.base.recyclerview.BaseViewHolder

class StickersAdapter : BaseAdapter<GalleryContent>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<*, GalleryContent> {
        return when (ContentType.getTypeFromAdapterTypeId(viewType)) {
            ContentType.HEADER -> CategoryHeader.buildVIewHolder(parent)
            ContentType.STICKER -> StickerViewHolder.buildVIewHolder(parent)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = itemList[position]
        return item.contentType.adapterTypeId
    }
}