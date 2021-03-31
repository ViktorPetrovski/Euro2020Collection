package com.euro.sticker.gallery.ui.adapter.view_holders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.euro.sticker.R
import com.euro.sticker.databinding.ViewStickerBinding
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.gallery.ui.adapter.content.GalleryContent
import com.euro.sticker.gallery.ui.adapter.content.StickerContent
import com.euro.sticker.uicommon.base.recyclerview.BaseViewHolder
import com.euro.sticker.uicommon.base.viewmodel.hiltNavGraphViewModels
import java.lang.RuntimeException

class StickerViewHolder(private val context: Context, private val itemBinding: ViewStickerBinding) :
    BaseViewHolder<ViewStickerBinding, GalleryContent>(itemBinding) {

    private val stickersGalleryViewModel: StickersGalleryViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    override fun bind(item: GalleryContent) {
        if (item !is StickerContent)
            throw RuntimeException("StickerViewHolder must accept StickerContent type")
        itemBinding.stickerNumberTV.text = item.number.toString()
        val drawable = if (item.amount == 0) {
            R.drawable.bg_missing_sticker
        } else {
            R.drawable.bg_collected_sticker
        }

        itemBinding.stickerHolder.background = ContextCompat.getDrawable(context, drawable)
        itemBinding.stickerHolder.setOnClickListener { stickersGalleryViewModel.addAmount(item) }
    }

    companion object {
        fun buildVIewHolder(parent: ViewGroup): StickerViewHolder {
            val bindings =
                ViewStickerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return StickerViewHolder(parent.context, bindings)
        }
    }
}