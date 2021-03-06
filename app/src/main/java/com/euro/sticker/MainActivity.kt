package com.euro.sticker

import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.euro.sticker.databinding.ActivityMainBinding
import com.euro.sticker.gallery.data.Repository
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.uicommon.base.doOnApplyWindowInsets
import com.euro.sticker.uicommon.base.viewmodel.MyVMProvider
import com.euro.sticker.uicommon.base.viewmodel.lifecycleOwner
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var provider: MyVMProvider

    @Inject
    lateinit var repository: Repository

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
        setStartDestination()
    }

    private fun setStartDestination() {
        lifecycleOwner.lifecycleScope.launch {
            val navHostFragment =
                (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
            val inflater = navHostFragment.navController.navInflater
            val graph = inflater.inflate(R.navigation.nav_graph)
            val isAlbumSelected = repository.isAlbumSelected()
            if (isAlbumSelected) {
                val stickersGalleryViewModel: StickersGalleryViewModel by provider.getViewModel()
                stickersGalleryViewModel.fetchInitialData()
                graph.startDestination = R.id.StickersGalleryFragment
            } else {
                lockDrawer()
                graph.startDestination = R.id.SelectAlbumFragment
            }
            navHostFragment.navController.graph = graph
        }
    }

    private fun setupDrawer() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        binding.navView.setupWithNavController(navController)
    }

    fun openDrawer() {
        binding.drawerLayout.openDrawer(Gravity.LEFT)
    }

    fun closeDrawer() {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    private fun lockDrawer() {
        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }
}