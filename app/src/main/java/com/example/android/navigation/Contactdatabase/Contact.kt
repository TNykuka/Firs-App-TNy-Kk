package com.example.android.navigation.Contactdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
data class Contact (
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0L,
        @ColumnInfo(name = "name")
        var name: String = "unnamed",
        @ColumnInfo(name = "phone")
        var phone: String = "unnamed",
        @ColumnInfo(name = "email")
        var e_mail: String = "unnamed"
)