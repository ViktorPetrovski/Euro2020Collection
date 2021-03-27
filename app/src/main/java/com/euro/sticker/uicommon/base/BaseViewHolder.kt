package com.euro.sticker.uicommon.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T>(
        val viewBindings: T,
) : RecyclerView.ViewHolder(viewBindings.root) where T : ViewBinding {
    abstract fun bind(item: Any)

    /**
     * Can be overridden to provide custom payload behavior to ViewHolders
     */
    open fun bind(item: Any, payloads: List<Any>) {
        bind(item)
    }
}