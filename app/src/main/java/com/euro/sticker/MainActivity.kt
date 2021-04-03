package com.euro.sticker

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.euro.sticker.databinding.ActivityMainBinding
import com.euro.sticker.gallery.data.Repository
import com.euro.sticker.gallery.ui.drawer.DrawerHeaderView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.drawerLayout.systemUiVisibility = FrameLayout.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        binding.navView.systemUiVisibility = FrameLayout.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        setupDrawer()
    }

    private fun setupDrawer() {
        binding.navView.addHeaderView(DrawerHeaderView(this))
    }

    fun openDrawer() {
        binding.drawerLayout.openDrawer(Gravity.LEFT)
    }
}