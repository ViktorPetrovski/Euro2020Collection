package com.euro.sticker.gallery.ui.drawer

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Toast
import androidx.navigation.findNavController
import com.euro.sticker.R
import com.euro.sticker.databinding.ViewDrawerBinding
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.uicommon.base.viewmodel.MyVMProvider
import com.euro.sticker.uicommon.base.viewmodel.createViewModelLazy
import com.euro.sticker.uicommon.base.viewmodel.hiltNavGraphViewModels
import com.euro.sticker.uicommon.base.viewmodel.lifecycleOwner
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import javax.inject.Inject

private const val TOTAL_STICKERS_COUNT = 654

@AndroidEntryPoint
class DrawerMenuView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : NavigationView(context, attrs, defStyleAttr) {

    private val binding = ViewDrawerBinding.inflate(LayoutInflater.from(context), this, true)
    @Inject
    lateinit var provider: MyVMProvider

    init {
        val stickersGalleryViewModel: StickersGalleryViewModel by provider.getViewModel()
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.allRb -> stickersGalleryViewModel.changeFilter(StickersGalleryViewModel.ViewFilter.All)
                R.id.missingRb -> stickersGalleryViewModel.changeFilter(StickersGalleryViewModel.ViewFilter.Missing)
                R.id.swapsRB -> stickersGalleryViewModel.changeFilter(StickersGalleryViewModel.ViewFilter.Swaps)
            }
        }

        stickersGalleryViewModel.getOwnedStickersCount.observe(context.lifecycleOwner) {
            binding.currentStatsNumbers.text = "$it/$TOTAL_STICKERS_COUNT"
            var percentage = ((it.toDouble() / TOTAL_STICKERS_COUNT) * 100).toInt()
            binding.currentStatsPercent.text = "$percentage%"
        }
    }
}