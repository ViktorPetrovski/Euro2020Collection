package com.euro.sticker.gallery.ui.adapter.view_holders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.euro.sticker.R
import com.euro.sticker.databinding.ViewStickerBinding
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.gallery.ui.model.GalleryContent
import com.euro.sticker.gallery.ui.model.StickerContent
import com.euro.sticker.uicommon.base.recyclerview.BaseViewHolder
import com.euro.sticker.uicommon.base.viewmodel.MyVMProvider
import com.euro.sticker.uicommon.base.viewmodel.hiltNavGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import java.lang.RuntimeException
import javax.inject.Inject


class StickerViewHolder(private val context: Context,
                        private val itemBinding: ViewStickerBinding,
                        private val itemClicked: (item: StickerContent) -> Unit) :
    BaseViewHolder<ViewStickerBinding, GalleryContent>(itemBinding) {

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
        itemBinding.stickerHolder.setOnClickListener { itemClicked.invoke(item) }

        itemBinding.stickerDuplicatesTV.isVisible = item.amount > 1
        itemBinding.stickerDuplicatesTV.text = "x${item.amount}"
    }

    companion object {
        fun buildVIewHolder(parent: ViewGroup, itemClicked: (item: StickerContent) -> Unit): StickerViewHolder {
            val bindings =
                ViewStickerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return StickerViewHolder(parent.context, bindings, itemClicked)
        }
    }
}