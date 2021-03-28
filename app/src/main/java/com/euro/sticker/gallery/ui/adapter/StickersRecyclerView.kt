package com.euro.sticker.gallery.ui.adapter

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.euro.sticker.R
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.uicommon.base.recyclerview.ColumnItemDecoration
import com.euro.sticker.uicommon.base.viewmodel.lifecycleOwner
import com.euro.sticker.uicommon.base.viewmodel.viewModel
import dagger.hilt.android.AndroidEntryPoint

private const val COLUMNS = 5

@AndroidEntryPoint
class StickersRecyclerView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private lateinit var stickersGalleryViewModel: StickersGalleryViewModel

    private val stickersAdapter = StickersAdapter()

    init {
        adapter = stickersAdapter
        layoutManager = GridLayoutManager(context, COLUMNS)
        addItemDecoration(ColumnItemDecoration())
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        stickersGalleryViewModel = findNavController().viewModel(R.id.nav_graph)
        stickersGalleryViewModel.getStickers.observe(context.lifecycleOwner) {
            stickersAdapter.itemList.addAll(it)
            stickersAdapter.notifyDataSetChanged()
        }
    }
}