package com.euro.sticker.gallery.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.euro.sticker.databinding.ViewStickerBinding
import com.euro.sticker.gallery.ui.adapter.content.CategoryContent
import com.euro.sticker.gallery.ui.adapter.content.GalleryContent
import com.euro.sticker.gallery.ui.adapter.content.StickerContent
import com.euro.sticker.uicommon.base.recyclerview.BaseViewHolder
import java.lang.RuntimeException

class StickerViewHolder(private val context: Context, private val itemBinding: ViewStickerBinding) :
    BaseViewHolder<ViewStickerBinding, GalleryContent>(itemBinding) {

    override fun bind(item: GalleryContent) {
        if (item !is StickerContent)
            throw RuntimeException("StickerViewHolder must accept StickerContent type")
        itemBinding.stickerNumberTV.text = item.number.toString()
    }

    companion object {
        fun buildVIewHolder(parent: ViewGroup): StickerViewHolder {
            val bindings =
                ViewStickerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return StickerViewHolder(parent.context, bindings)
        }
    }
}