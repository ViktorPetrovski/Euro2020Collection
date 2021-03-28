package com.euro.sticker.uicommon.base.recyclerview

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T, V>(
        val viewBindings: T,
) : RecyclerView.ViewHolder(viewBindings.root) where T : ViewBinding {
    abstract fun bind(item: V)

    /**
     * Can be overridden to provide custom payload behavior to ViewHolders
     */
    open fun bind(item: V, payloads: List<Any>) {
        bind(item)
    }
}