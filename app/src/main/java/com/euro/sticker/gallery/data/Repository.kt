package com.euro.sticker.gallery.data

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.euro.sticker.gallery.data.model.CategoryEntity
import com.euro.sticker.gallery.data.tmp.Category
import com.euro.sticker.gallery.domain.model.CategoryModel
import com.euro.sticker.gallery.domain.model.ViewFilter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException
import java.lang.reflect.Type
import javax.inject.Inject


class Repository @Inject constructor(
    private val stickersDao: StickersDao,
    private val mySharedPreferences: MySharedPreferences,
    @ApplicationContext private val context: Context
) {

    private val missing_pos = listOf(2, 7, 12, 17, 22, 27)

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun fixDb() {
        val gson = Gson()
//
//        // create a reader
//
//        // create a reader
//        val reader = getJsonDataFromAsset(context, "panini.json")
//
//        val userListType: Type = object :
//            TypeToken<ArrayList<Category?>?>() {}.type
//
//        val categories: ArrayList<Category> =
//            gson.fromJson(reader, userListType)
//
//        val toAdd = mutableListOf<CategoryEntity>()
//        categories.forEach { category ->
//            if (missing_pos.contains(category.position))
//                stickersDao.insertCategory(CategoryEntity(uid = category.position.toLong(), name = category.name))
//            Log.v("Repository", category.toString())
//            category.stickers.forEach {
//                stickersDao.insertStickers(StickerEntity(
//                    name = it.name,
//                    number = it.position,
//                    categoryId = category.position.toLong(),
//                    albumId = 2
//                ))
//            }
//        }
//        categories.forEach { category ->
//            Log.v("Repository", category.toString())
//            category.stickers.forEach {
//                stickersDao.insertStickers(StickerEntity(
//                    name = it.name,
//                    number = it.position,
//                    categoryId = category.position.toLong(),
//                    albumId = 3
//                ))
//            }
//        }
    }

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    suspend fun getAllStickers(): List<CategoryModel> {
        return stickersDao.getCategoriesAndStickers().map { CategoryModel(it) }
    }

    suspend fun updateSticker(newAmount: Int, number: Int) = stickersDao.updateSticker(
        newAmount,
        number
    )

    fun getFilter(): ViewFilter = mySharedPreferences.get()

    fun changeFilter(setFilter: ViewFilter) = mySharedPreferences.setStoredTag(setFilter)
}