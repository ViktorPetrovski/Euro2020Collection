package com.euro.sticker.gallery.data

import com.euro.sticker.gallery.domain.model.CategoryModel
import javax.inject.Inject

class Repository @Inject constructor(private val stickersDao: StickersDao) {

    suspend fun fixDB() {
        var index = 1
        return stickersDao.getAllStickers().forEach {
            if (it.number != index)
                stickersDao.updateStickerNumber(it.uid, index)
            index ++
        }
    }

    suspend fun getAllStickers(): List<CategoryModel> {
        return stickersDao.getCategoriesAndStickers().map { CategoryModel(it) }
    }

    suspend fun updateSticker(newAmount: Int, number: Int) = stickersDao.updateSticker(newAmount, number)
}