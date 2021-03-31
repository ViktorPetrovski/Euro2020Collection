package com.euro.sticker.gallery.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.euro.sticker.databinding.ViewGroupTitleBinding
import com.euro.sticker.gallery.ui.adapter.content.CategoryContent
import com.euro.sticker.gallery.ui.adapter.content.GalleryContent
import com.euro.sticker.uicommon.base.recyclerview.BaseViewHolder
import java.lang.RuntimeException

class CategoryHeader(
    private val context: Context,
    private val itemBinding: ViewGroupTitleBinding
) : BaseViewHolder<ViewGroupTitleBinding, GalleryContent>(itemBinding) {

    override fun bind(item: GalleryContent) {
        if (item !is CategoryContent)
            throw RuntimeException("CategoryHeader must accept CategoryContent type")
        itemBinding.headerTitle.text = item.categoryName
    }

    companion object {
        fun buildVIewHolder(parent: ViewGroup): CategoryHeader {
            val bindings =
                ViewGroupTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return CategoryHeader(parent.context, bindings)
        }
    }
}