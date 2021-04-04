package com.euro.sticker.gallery.ui.adapter.view_holders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.euro.sticker.databinding.ViewGroupTitleBinding
import com.euro.sticker.gallery.ui.model.CategoryContent
import com.euro.sticker.gallery.ui.model.GalleryContent
import com.euro.sticker.uicommon.base.recyclerview.BaseViewHolder
import java.lang.RuntimeException

class CategoryViewHolder(
    private val context: Context,
    private val itemBinding: ViewGroupTitleBinding
) : BaseViewHolder<ViewGroupTitleBinding, GalleryContent>(itemBinding) {

    override fun bind(item: GalleryContent) {
        if (item !is CategoryContent)
            throw RuntimeException("CategoryHeader must accept CategoryContent type")
        itemBinding.headerTitle.text = item.categoryName
        itemBinding.categoryCount.text = "${item.collectedStickers}/${item.totalStickersInCategory}"
    }

    companion object {
        fun buildVIewHolder(parent: ViewGroup): CategoryViewHolder {
            val bindings =
                ViewGroupTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return CategoryViewHolder(parent.context, bindings)
        }
    }
}