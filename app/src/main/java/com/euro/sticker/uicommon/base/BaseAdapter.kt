package com.euro.sticker.uicommon.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<V> : RecyclerView.Adapter<BaseViewHolder<*, V>>() {
    val itemList = arrayListOf<V>()

    override fun onBindViewHolder(holder: BaseViewHolder<*, V>, position: Int) {
        holder.bind(itemList[position])
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<*, V>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        holder.bind(itemList[position], payloads)
    }

    override fun getItemCount() = itemList.size
}
