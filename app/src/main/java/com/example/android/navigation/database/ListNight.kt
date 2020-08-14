package com.example.android.navigation.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_list_quality_table")
data class ListNight(
        @PrimaryKey(autoGenerate = true)
        var namelistId: Long = 0L,

        @ColumnInfo(name = "name_list_Quality")
        var namelistQuality: String = ""
)