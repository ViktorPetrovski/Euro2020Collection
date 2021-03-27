package com.euro.sticker.gallery.ui.adapter

import com.euro.sticker.databinding.ViewStickerBinding
import com.euro.sticker.uicommon.base.BaseViewHolder

class StickerViewHolder(private val itemBinding: ViewStickerBinding) : BaseViewHolder<ViewStickerBinding>(itemBinding) {

    override fun bind(item: Any) {
        itemBinding.stickerNumberTV.text = "$adapterPosition"
    }
}