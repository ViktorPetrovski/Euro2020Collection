package com.euro.sticker.uicommon.base.viewmodel

import android.content.Context
import android.content.ContextWrapper
import androidx.annotation.NavigationRes
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import java.lang.RuntimeException

inline fun <reified T : ViewModel> NavController.viewModel(@NavigationRes navGraphId: Int): T {
    val storeOwner = getViewModelStoreOwner(navGraphId)
    return ViewModelProvider(storeOwner)[T::class.java]
}

val Context.lifecycleOwner: LifecycleOwner
    get() {
        var context: Context? = this

        while (context != null && context !is LifecycleOwner) {
            val baseContext = (context as? ContextWrapper?)?.baseContext
            context = if (baseContext == context) null else baseContext
        }

        return if (context is LifecycleOwner) context else throw RuntimeException("Can't access lifecycle owner from context")
    }