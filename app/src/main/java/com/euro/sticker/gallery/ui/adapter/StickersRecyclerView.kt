package com.euro.sticker.gallery.ui.adapter

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.euro.sticker.R
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.gallery.ui.adapter.content.ContentType
import com.euro.sticker.uicommon.base.recyclerview.ColumnItemDecoration
import com.euro.sticker.uicommon.base.viewmodel.hiltNavGraphViewModels
import com.euro.sticker.uicommon.base.viewmodel.lifecycleOwner
import dagger.hilt.android.AndroidEntryPoint

private const val COLUMNS = 6
private const val FULL_COLUMN_WIDTH = 1

@AndroidEntryPoint
class StickersRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    val stickersGalleryViewModel: StickersGalleryViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    private val stickersAdapter = StickersAdapter()
    private val gridManager = GridLayoutManager(context, COLUMNS)

    init {
        adapter = stickersAdapter
        adjustCorrectSpanSize()
        layoutManager = gridManager
        addItemDecoration(ColumnItemDecoration())

    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        stickersGalleryViewModel.getStickers.observe(context.lifecycleOwner) {
            stickersAdapter.itemList.addAll(it)
            stickersAdapter.notifyDataSetChanged()
        }
    }

    private fun adjustCorrectSpanSize() {
        gridManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (stickersAdapter.getItemViewType(position)) {
                    ContentType.STICKER.adapterTypeId -> FULL_COLUMN_WIDTH
                    ContentType.HEADER.adapterTypeId -> COLUMNS
                    else -> FULL_COLUMN_WIDTH
                }
            }
        }
    }
}