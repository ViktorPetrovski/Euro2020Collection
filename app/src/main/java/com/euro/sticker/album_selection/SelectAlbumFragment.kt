package com.euro.sticker.album_selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.euro.sticker.databinding.FragmentSelectAlbumBinding
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.uicommon.base.doOnApplyWindowInsets
import com.euro.sticker.uicommon.base.viewmodel.MyVMProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SelectAlbumFragment : Fragment() {

    @Inject
    lateinit var provider: MyVMProvider

    private var _binding: FragmentSelectAlbumBinding? = null
    private val binding get() = _binding!!

    private val albumsAdapter = AlbumAdapter(::onAlbumClicked)

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
        binding.albumsRecyclerView.adapter = albumsAdapter
        binding.albumsRecyclerView.layoutManager = LinearLayoutManager(context)
        val stickersGalleryViewModel: StickersGalleryViewModel by provider.getViewModel()
        stickersGalleryViewModel.allAlbums.observe(viewLifecycleOwner) {
            albumsAdapter.itemList.clear()
            albumsAdapter.itemList.addAll(it)
            albumsAdapter.notifyDataSetChanged()
        }
        stickersGalleryViewModel.loadAlbums()
    }

    private fun onAlbumClicked(albumModel: AlbumModel) {
        val stickersGalleryViewModel: StickersGalleryViewModel by provider.getViewModel()
        stickersGalleryViewModel.albumSelected(albumModel)
        Toast.makeText(context, "Selected: ${albumModel.name}", Toast.LENGTH_LONG).show()
        findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}