package com.usunin1994.myauto.feature.main_screen.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.usunin1994.myauto.feature.main_screen.db.AutoEntity

@Dao
interface AutoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuto(auto: AutoEntity)

    @Query("SELECT * FROM auto_table ORDER BY entryDate DESC")
    suspend fun getAutoList(): List<AutoEntity>
}