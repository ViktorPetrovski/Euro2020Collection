package com.euro.sticker.uicommon.base.viewmodel

import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MyVMProvider @Inject constructor(val activity: FragmentActivity) {

    inline fun <reified VM : ViewModel> getViewModel(): Lazy<VM> = activity.viewModels()
}