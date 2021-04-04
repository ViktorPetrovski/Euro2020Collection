package com.euro.sticker

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.euro.sticker.databinding.ActivityMainBinding
import com.euro.sticker.gallery.data.Repository
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.gallery.ui.adapter.StickersRecyclerView
import com.euro.sticker.gallery.ui.drawer.DrawerHeaderView
import com.euro.sticker.uicommon.base.doOnApplyWindowInsets
import com.euro.sticker.uicommon.base.viewmodel.MyVMProvider
import com.euro.sticker.uicommon.base.viewmodel.hiltNavGraphViewModels
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var provider: MyVMProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.drawerLayout.systemUiVisibility = FrameLayout.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        binding.navView.systemUiVisibility = FrameLayout.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        setupDrawer()

        binding.root.doOnApplyWindowInsets { _, windowInsets, initialPadding ->
            binding.navView.applyWindowInsets(windowInsets.systemWindowInsetTop)
        }
    }

    private fun setupDrawer() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        binding.navView.setupWithNavController(navController)

//        val stickersGalleryViewModel: StickersGalleryViewModel by provider.getViewModel()
//        binding.navView.setOnFilterChangedListener {
//            stickersGalleryViewModel.changeFilter(it)
//        }
    }

    fun openDrawer() {
        binding.drawerLayout.openDrawer(Gravity.LEFT)
    }
}