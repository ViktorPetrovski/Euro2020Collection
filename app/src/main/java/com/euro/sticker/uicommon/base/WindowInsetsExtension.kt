package com.euro.sticker.uicommon.base

import android.view.View
import android.view.WindowInsets
import androidx.core.view.updatePadding

fun View.doOnApplyWindowInsets(f: (View, WindowInsets, InitialPadding) -> Unit) {
    // Create a snapshot of the view's padding state
    val initialPadding = getInitialPaddingForView(this)
    // Set an actual OnApplyWindowInsetsListener which proxies to the given
    // lambda, also passing in the original padding state
    setOnApplyWindowInsetsListener { v, insets ->
        f(v, insets, initialPadding)
        // Always return the insets, so that children can also use them
        insets
    }

    requestApplyInsets()
}

/**
 * Requests insets for View.
 * If the view is attached we request them immediately, else we wait until the view is attached
 * */
fun View.requestApplyInsetsWhenAttached() {
    if (isAttachedToWindow) {
        requestApplyInsets()
    } else {
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                v.removeOnAttachStateChangeListener(this)
                v.requestApplyInsets()
            }

            override fun onViewDetachedFromWindow(v: View) = Unit
        })
    }
}

fun View.applyTopWindowInsetsPadding() {
    doOnApplyWindowInsets { view, windowInsets, padding ->
        updatePadding(top = windowInsets.systemWindowInsetTop + padding.top)
    }
}

fun View.applyBottomWindowInsetsPadding() {
    doOnApplyWindowInsets { view, windowInsets, padding ->
        updatePadding(bottom = windowInsets.systemWindowInsetBottom + padding.bottom)
    }
}

data class InitialPadding(val left: Int, val top: Int,
                          val right: Int, val bottom: Int)

private fun getInitialPaddingForView(view: View) = InitialPadding(
    view.paddingLeft, view.paddingTop, view.paddingRight, view.paddingBottom)