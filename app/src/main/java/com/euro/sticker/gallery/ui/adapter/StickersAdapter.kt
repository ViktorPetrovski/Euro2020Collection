package com.euro.sticker.gallery.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.euro.sticker.uicommon.base.BaseAdapter
import com.euro.sticker.uicommon.base.BaseViewHolder

class StickersAdapter : BaseAdapter<Int>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, Int> {
        return StickerViewHolder.buildVIewHolder(parent)
    }

}