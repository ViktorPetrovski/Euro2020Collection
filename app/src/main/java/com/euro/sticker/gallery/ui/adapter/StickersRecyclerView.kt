package com.euro.sticker.gallery.ui.adapter

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val COLUMNS = 6

@AndroidEntryPoint
class StickersRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    @Inject
    lateinit var stickersGalleryViewModel: StickersGalleryViewModel

    private val stickersAdapter = StickersAdapter()

    init {
        adapter = stickersAdapter
        layoutManager = GridLayoutManager(context, COLUMNS)

    }
}