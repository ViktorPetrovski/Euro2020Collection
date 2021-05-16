package com.euro.sticker.gallery.ui.adapter

import android.content.Context
import android.util.AttributeSet
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.gallery.ui.dialog.StickerDialogFragment
import com.euro.sticker.gallery.ui.model.ContentType
import com.euro.sticker.gallery.ui.model.StickerContent
import com.euro.sticker.uicommon.base.recyclerview.ColumnItemDecoration
import com.euro.sticker.uicommon.base.viewmodel.MyVMProvider
import com.euro.sticker.uicommon.base.viewmodel.lifecycleOwner
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.managers.FragmentComponentManager
import javax.inject.Inject

private const val COLUMNS = 6
private const val FULL_COLUMN_WIDTH = 1

@AndroidEntryPoint
class StickersRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    @Inject
    lateinit var provider: MyVMProvider
    private val stickersAdapter = StickersAdapter(::onItemClicked)
    private val gridManager = GridLayoutManager(context, COLUMNS)
    init {
        adapter = stickersAdapter
        adjustCorrectSpanSize()
        layoutManager = gridManager
        addItemDecoration(ColumnItemDecoration())
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val stickersGalleryViewModel: StickersGalleryViewModel by provider.getViewModel()
        stickersGalleryViewModel.getStickers.observe(context.lifecycleOwner) {
            val diffResult =
                DiffUtil.calculateDiff(StickersDiffCallback(stickersAdapter.itemList, it))
            stickersAdapter.itemList.clear()
            stickersAdapter.itemList.addAll(it)
            diffResult.dispatchUpdatesTo(stickersAdapter)
        }
    }

    private fun adjustCorrectSpanSize() {
        gridManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (position == -1)
                    return COLUMNS
                return when (stickersAdapter.getItemViewType(position)) {
                    ContentType.STICKER.adapterTypeId -> FULL_COLUMN_WIDTH
                    ContentType.HEADER.adapterTypeId -> COLUMNS
                    else -> FULL_COLUMN_WIDTH
                }
            }
        }
    }

    private fun onItemClicked(item: StickerContent) {
        if (item.amount == 0) {
            val stickersGalleryViewModel: StickersGalleryViewModel by provider.getViewModel()
            stickersGalleryViewModel.addAmount(item)
        } else {
            val activity = FragmentComponentManager.findActivity(context)
            StickerDialogFragment.show(activity as AppCompatActivity, item)
        }
    }
}