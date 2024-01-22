package com.usunin1994.myauto.feature.main_screen.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.usunin1994.myauto.feature.main_screen.db.dao.AutoDao

@Database(version = 1, entities = [AutoEntity::class])

abstract class AppDatabase : RoomDatabase() {

    abstract fun autoDao(): AutoDao
}