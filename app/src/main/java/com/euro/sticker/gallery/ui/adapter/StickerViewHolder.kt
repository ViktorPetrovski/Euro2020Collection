package com.euro.sticker.gallery.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.euro.sticker.databinding.ViewStickerBinding
import com.euro.sticker.uicommon.base.recyclerview.BaseViewHolder

class StickerViewHolder(private val context: Context, private val itemBinding: ViewStickerBinding) : BaseViewHolder<ViewStickerBinding, Int>(itemBinding) {

    override fun bind(item: Int) {
        itemBinding.stickerNumberTV.text = "$item"
    }

    companion object {
        fun buildVIewHolder(parent: ViewGroup): StickerViewHolder {
            val bindings = ViewStickerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return StickerViewHolder(parent.context, bindings)
        }
    }
}