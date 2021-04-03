package com.euro.sticker.gallery.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.euro.sticker.gallery.data.model.CategoryEntity
import com.euro.sticker.gallery.data.model.StickerEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DB_ASSETS_FILE = "database/StickersDB.db"
private const val DB_NAME = "StickersDB"

@Database(entities = [StickerEntity::class, CategoryEntity::class], version = 1)
abstract class StickersDB : RoomDatabase() {
    abstract fun stickersDao(): StickersDao
}

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideStickersDao(appDatabase: StickersDB): StickersDao {
        return appDatabase.stickersDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): StickersDB {
        return Room.databaseBuilder(
            appContext,
            StickersDB::class.java,
            DB_NAME
        ).createFromAsset(DB_ASSETS_FILE).build()
    }
}
