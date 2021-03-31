package com.euro.sticker.uicommon.base.viewmodel

import android.content.Context
import android.content.ContextWrapper
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.MainThread
import androidx.annotation.NavigationRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import java.lang.RuntimeException
import kotlin.reflect.KClass

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

@MainThread
@Suppress("MissingNullability") // Due to https://youtrack.jetbrains.com/issue/KT-39209
inline fun <reified VM : ViewModel> RecyclerView.ViewHolder.hiltNavGraphViewModels(
    @IdRes navGraphId: Int
): Lazy<VM> {
    val backStackEntry by lazy {
        itemView.findNavController().getBackStackEntry(navGraphId)
    }
    val storeProducer: () -> ViewModelStore = {
        backStackEntry.viewModelStore
    }
    return createViewModelLazy(
        VM::class, storeProducer,
        {
            HiltViewModelFactory(itemView.context, backStackEntry)
        }
    )
}

@MainThread
@Suppress("MissingNullability") // Due to https://youtrack.jetbrains.com/issue/KT-39209
inline fun <reified VM : ViewModel> View.hiltNavGraphViewModels(
    @IdRes navGraphId: Int
): Lazy<VM> {
    val backStackEntry by lazy {
        findNavController().getBackStackEntry(navGraphId)
    }
    val storeProducer: () -> ViewModelStore = {
        backStackEntry.viewModelStore
    }
    return createViewModelLazy(
        VM::class, storeProducer,
        {
            HiltViewModelFactory(context, backStackEntry)
        }
    )
}

@MainThread
fun <VM : ViewModel> createViewModelLazy(
    viewModelClass: KClass<VM>,
    storeProducer: () -> ViewModelStore,
    factoryProducer: (() -> ViewModelProvider.Factory)
): Lazy<VM> {
    return ViewModelLazy(viewModelClass, storeProducer, factoryProducer)
}