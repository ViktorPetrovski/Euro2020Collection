package com.euro.sticker.gallery.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.euro.sticker.databinding.ViewFilterByBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterByView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ViewFilterByBinding.inflate(LayoutInflater.from(context), this, true)

}