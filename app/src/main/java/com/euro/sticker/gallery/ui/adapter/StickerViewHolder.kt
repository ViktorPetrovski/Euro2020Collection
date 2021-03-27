package com.euro.sticker.gallery.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.euro.sticker.databinding.ViewStickerBinding
import com.euro.sticker.uicommon.base.BaseViewHolder

class StickerViewHolder(private val itemBinding: ViewStickerBinding) : BaseViewHolder<ViewStickerBinding, Int>(itemBinding) {

    override fun bind(item: Int) {
        itemBinding.stickerNumberTV.text = "$adapterPosition"
    }

    companion object {
        fun buildVIewHolder(parent: ViewGroup): StickerViewHolder {
            val bindings = ViewStickerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return StickerViewHolder(bindings)
        }
    }
}