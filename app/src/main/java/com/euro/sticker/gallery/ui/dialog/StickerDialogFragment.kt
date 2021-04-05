package com.euro.sticker.gallery.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.euro.sticker.R
import com.euro.sticker.databinding.DialogStickerDetailsBinding
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.gallery.ui.model.StickerContent
import com.euro.sticker.uicommon.base.viewmodel.MyVMProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StickerDialogFragment(private var stickerContent: StickerContent): DialogFragment() {

    @Inject
    lateinit var provider: MyVMProvider


    private lateinit var binding: DialogStickerDetailsBinding

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dialog?.window?.attributes?.windowAnimations = R.style.DialogAnimation
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val stickersGalleryViewModel: StickersGalleryViewModel by provider.getViewModel()
        binding = DialogStickerDetailsBinding.inflate(LayoutInflater.from(context), null, false)
        dialog.setContentView(binding.root)
        binding.stickerNumber.text = stickerContent.number.toString()
        binding.stickerName.text = stickerContent.name
        setAmountStyle()
        binding.addAmount.setOnClickListener {
            stickersGalleryViewModel.addAmount(stickerContent)
            stickerContent = stickerContent.copy(amount = stickerContent.amount + 1)
            setAmountStyle()
        }
        binding.removeAmount.setOnClickListener {
            stickersGalleryViewModel.removeAmount(stickerContent)
            stickerContent = stickerContent.copy(amount = stickerContent.amount -1)
            setAmountStyle()
        }
        return dialog
    }

    private fun setAmountStyle() {
        binding.amount.text = stickerContent.amount.toString()
        if (stickerContent.amount == 0) {
            binding.removeAmount.isEnabled = false
            binding.removeAmount.alpha = .4f
        } else {
            binding.removeAmount.isEnabled = true
            binding.removeAmount.alpha = 1f
        }
    }

    override fun onStart() {
        super.onStart()
        positionDialog()
    }

    private fun positionDialog() {
        dialog?.window?.apply {
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawableResource(R.drawable.bg_dialog)
            setGravity(Gravity.BOTTOM)
        }
    }

    companion object {
        fun show(activity: AppCompatActivity, stickerContent: StickerContent) {
            val fragment = StickerDialogFragment(stickerContent)
            fragment.show(activity.supportFragmentManager, fragment.javaClass.name)
        }
    }
}