package com.euro.sticker.gallery.ui.dialog

import android.content.Context
import android.os.CountDownTimer
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.euro.sticker.databinding.ViewStickerAddedBinding
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.gallery.ui.model.StickerContent
import com.euro.sticker.uicommon.base.viewmodel.MyVMProvider
import com.euro.sticker.uicommon.base.viewmodel.lifecycleOwner
import com.euro.sticker.uicommon.base.viewmodel.slideDown
import com.euro.sticker.uicommon.base.viewmodel.slideUp
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val TIMER_LENGTH = 2500L

@AndroidEntryPoint
class StickerAddedView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding = ViewStickerAddedBinding.inflate(LayoutInflater.from(context), this, true)

    @Inject
    lateinit var provider: MyVMProvider

    private var currentSticker: StickerContent? = null

    private val countDownTimer = object : CountDownTimer(TIMER_LENGTH, TIMER_LENGTH) {
        override fun onTick(millisUntilFinished: Long) {
            // no op
        }

        override fun onFinish() {
            slideDown()
            currentSticker = null
        }
    }

    init {
        visibility = View.GONE
        val stickersGalleryViewModel: StickersGalleryViewModel by provider.getViewModel()
        stickersGalleryViewModel.stickerAdded.observe(context.lifecycleOwner) {
            showSticker(it)
        }
        binding.undo.setOnClickListener {
            currentSticker?.let {
                stickersGalleryViewModel.removeAmount(it)
            }
            countDownTimer.cancel()
            slideDown()
        }
    }

    private fun showSticker(sticker: StickerContent) {
        countDownTimer.cancel()
        currentSticker = sticker
        binding.stickerText.text = "${sticker.number}. ${sticker.name}"
        slideUp()
        countDownTimer.start()
    }
}