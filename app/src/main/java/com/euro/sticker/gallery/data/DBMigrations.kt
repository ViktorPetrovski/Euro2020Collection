package com.euro.sticker.gallery.data

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE `Album` (`id` INTEGER, `name` TEXT, `stickers_count` INTEGER, " +
                    "PRIMARY KEY(`id`))"
        )
        database.execSQL(
            "INSERT INTO `Album` (`id`, `name`, `stickers_count`) VALUES\n" +
                    "('1', 'Blue Cover - Panini UEFA Euro 2020 Tournament Edition', '654'),\n" +
                    "('2', 'Orange Cover - Panini UEFA Euro 2020 Tournament Edition', '678'),\n" +
                    "('3', 'Pearl Edition - Panini UEFA Euro 2020', '678')"
        )
        database.execSQL("ALTER TABLE StickerEntity ADD album_id INTEGER NOT NULL DEFAULT(1)")
    }
}
