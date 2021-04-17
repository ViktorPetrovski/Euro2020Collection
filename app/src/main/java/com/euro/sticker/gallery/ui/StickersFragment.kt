package com.euro.sticker.gallery.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.euro.sticker.MainActivity
import com.euro.sticker.databinding.FragmentFirstBinding
import com.euro.sticker.uicommon.base.doOnApplyWindowInsets
import com.euro.sticker.uicommon.base.fragment.BaseFragment
import com.euro.sticker.uicommon.base.viewmodel.MyVMProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StickersFragment : BaseFragment<FragmentFirstBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFirstBinding =
        FragmentFirstBinding::inflate

    @Inject
    lateinit var provider: MyVMProvider

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.drawerImage.setOnClickListener {
            (requireActivity() as MainActivity).openDrawer()
        }
        binding.statusBar.doOnApplyWindowInsets { _, windowInsets, initialPadding ->
            binding.statusBar.layoutParams.height = windowInsets.systemWindowInsetTop
        }
    }


}