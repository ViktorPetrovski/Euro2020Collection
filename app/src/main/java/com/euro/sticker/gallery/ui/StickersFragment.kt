package com.euro.sticker.gallery.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.euro.sticker.MainActivity
import com.euro.sticker.databinding.FragmentFirstBinding
import com.euro.sticker.uicommon.base.doOnApplyWindowInsets
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StickersFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.drawerImage.setOnClickListener {
            (requireActivity() as MainActivity).openDrawer()
        }
        binding.statusBar.doOnApplyWindowInsets { _, windowInsets, initialPadding ->
            binding.statusBar.layoutParams.height = windowInsets.systemWindowInsetTop
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}