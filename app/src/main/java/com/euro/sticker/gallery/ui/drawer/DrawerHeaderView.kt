package com.euro.sticker.gallery.ui.drawer

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.euro.sticker.R
import com.euro.sticker.databinding.ViewDrawerHeaderBinding
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.uicommon.base.viewmodel.hiltNavGraphViewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DrawerHeaderView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ViewDrawerHeaderBinding.inflate(LayoutInflater.from(context), this, true)

    val stickersGalleryViewModel: StickersGalleryViewModel by hiltNavGraphViewModels(R.id.nav_graph)


}