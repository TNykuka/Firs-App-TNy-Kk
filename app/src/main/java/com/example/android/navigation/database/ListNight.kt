package com.example.android.navigation.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_list_quality_table")
data class ListNight(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "subscriber_name")
        var id : Int,

        @ColumnInfo(name = "subscriber_id")
        var name : String

)