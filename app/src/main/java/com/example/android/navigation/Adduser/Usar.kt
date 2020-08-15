package com.example.android.navigation.Adduser

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class Usar(
        @PrimaryKey
        @ColumnInfo(name = "user")
        val user: String)