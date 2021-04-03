package com.euro.sticker.gallery.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.bumptech.glide.Glide
import com.euro.sticker.R
import com.euro.sticker.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

private const val URL = "https://thumbs.dreamstime.com/z/abstract-fluid-color-background-summer-travel-sale-banner-colorful-shapes-wavy-geometric-modern-design-minimal-vector-wallpaper-145884397.jpg"
@AndroidEntryPoint
class StickersFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}