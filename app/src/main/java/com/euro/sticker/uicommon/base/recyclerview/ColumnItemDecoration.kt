package com.euro.sticker.uicommon.base.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class ColumnItemDecoration : ItemDecoration() {
    // Horizontal padding
    private val padding = 0
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val layoutParams = view.layoutParams as GridLayoutManager.LayoutParams
        val gridLayoutManager = parent.layoutManager as GridLayoutManager?
        val position = parent.getChildViewHolder(view).adapterPosition
        val spanSize = gridLayoutManager!!.spanSizeLookup.getSpanSize(position).toFloat()
        val totalSpanSize = gridLayoutManager.spanCount.toFloat()
        val n = totalSpanSize / spanSize // num columns
        val c = layoutParams.spanIndex / spanSize // column index
        val leftPadding = padding * ((n - c) / n)
        val rightPadding = padding * ((c + 1) / n)
        outRect.left = leftPadding.toInt()
        outRect.right = rightPadding.toInt()
    }
}
