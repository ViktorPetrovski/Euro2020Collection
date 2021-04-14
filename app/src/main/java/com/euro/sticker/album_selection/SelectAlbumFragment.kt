package com.euro.sticker.album_selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.euro.sticker.databinding.FragmentSelectAlbumBinding
import com.euro.sticker.uicommon.base.doOnApplyWindowInsets
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectAlbumFragment : Fragment() {

    private var _binding: FragmentSelectAlbumBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.statusBar.doOnApplyWindowInsets { _, windowInsets, initialPadding ->
            binding.statusBar.layoutParams.height = windowInsets.systemWindowInsetTop
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}