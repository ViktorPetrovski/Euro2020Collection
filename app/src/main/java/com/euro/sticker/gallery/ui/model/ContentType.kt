package com.euro.sticker.gallery.ui.model

import java.lang.RuntimeException

enum class ContentType(val adapterTypeId: Int) {
    HEADER(AdapterTypeId.SECTION_TITLE),
    STICKER(AdapterTypeId.STICKER_DEFAULT);

    companion object {
        fun getTypeFromAdapterTypeId(adapterId: Int) = when (adapterId) {
            AdapterTypeId.SECTION_TITLE -> HEADER
            AdapterTypeId.STICKER_DEFAULT -> STICKER
            else -> throw RuntimeException("Unknown Content type")
        }
    }

    private object AdapterTypeId {
        const val SECTION_TITLE = 0
        const val STICKER_DEFAULT = 1
    }
}