package com.usunin1994.myauto.feature.main_screen.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "auto_table")
data class AutoEntity (
    val brand: String,
    val image: String?,
    val year: String,
    val engine: String,
    @PrimaryKey
    val entryDate: String
)