package com.euro.sticker.gallery.ui.drawer

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.navigation.Navigation
import com.euro.sticker.MainActivity
import com.euro.sticker.R
import com.euro.sticker.databinding.ViewDrawerBinding
import com.euro.sticker.gallery.domain.model.ViewFilter
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.uicommon.base.viewmodel.MyVMProvider
import com.euro.sticker.uicommon.base.viewmodel.lifecycleOwner
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

private const val TOTAL_STICKERS_COUNT = 654
private const val INTENT_TEXT_TYPE = "text/plain"

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

        when (stickersGalleryViewModel.getSelectedFilter()) {
            ViewFilter.All -> binding.radioGroup.check(R.id.allRb)
            ViewFilter.Missing -> binding.radioGroup.check(R.id.missingRb)
            ViewFilter.Swaps -> binding.radioGroup.check(R.id.swapsRB)
        }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.allRb -> stickersGalleryViewModel.changeFilter(ViewFilter.All)
                R.id.missingRb -> stickersGalleryViewModel.changeFilter(ViewFilter.Missing)
                R.id.swapsRB -> stickersGalleryViewModel.changeFilter(ViewFilter.Swaps)
            }
        }

        stickersGalleryViewModel.getOwnedStickersCount.observe(context.lifecycleOwner) {
            binding.currentStatsNumbers.text = "$it/$TOTAL_STICKERS_COUNT"
            var percentage = ((it.toDouble() / TOTAL_STICKERS_COUNT) * 100).toInt()
            binding.currentStatsPercent.text = "$percentage%"
        }

        binding.shareMissingStickers.setOnClickListener {
            val missingStickersString = String.format(context.getString(R.string.missing_stickers_share), stickersGalleryViewModel.getMissingStickersString())
            shareStickers(missingStickersString)
        }

        binding.shareDuplicatestickers.setOnClickListener {
            val missingStickersString = String.format(context.getString(R.string.duplicates_stickers_share), stickersGalleryViewModel.getDuplicateStickersString())
            shareStickers(missingStickersString)
        }

        binding.changeAlbum.setOnClickListener {
            val activity = (context as? MainActivity) ?: return@setOnClickListener
            val navController = Navigation.findNavController(activity, R.id.nav_host_fragment)
            navController.navigate(R.id.SelectAlbumFragment)
            activity.closeDrawer()
        }
    }

    private fun shareStickers(text: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = INTENT_TEXT_TYPE
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        context.startActivity(shareIntent)
    }

    fun applyWindowInsets(topInsets: Int) {
        binding.statusBar.layoutParams.height = topInsets
    }
}