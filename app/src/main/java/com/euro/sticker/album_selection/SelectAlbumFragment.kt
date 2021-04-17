package com.euro.sticker.album_selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.euro.sticker.MainActivity
import com.euro.sticker.R
import com.euro.sticker.databinding.FragmentSelectAlbumBinding
import com.euro.sticker.gallery.ui.StickersGalleryViewModel
import com.euro.sticker.uicommon.base.doOnApplyWindowInsets
import com.euro.sticker.uicommon.base.fragment.BaseFragment
import com.euro.sticker.uicommon.base.viewmodel.MyVMProvider
import com.euro.sticker.uicommon.base.viewmodel.isFragmentRemovedFromBackStack
import com.google.android.gms.common.util.Strings
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SelectAlbumFragment : BaseFragment<FragmentSelectAlbumBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSelectAlbumBinding = FragmentSelectAlbumBinding::inflate
    @Inject
    lateinit var provider: MyVMProvider
    private val albumsAdapter = AlbumAdapter(::onAlbumClicked)

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
        if (albumModel.isSelected) {
            findNavController().popBackStack()
            return
        }
        val stickersGalleryViewModel: StickersGalleryViewModel by provider.getViewModel()
        stickersGalleryViewModel.albumSelected(albumModel)
        val albumSelected = String.format(getString(R.string.album_selected), albumModel.name)
        Toast.makeText(context, albumSelected, Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_First_Launch_Gallery_Fragment)
    }
}
