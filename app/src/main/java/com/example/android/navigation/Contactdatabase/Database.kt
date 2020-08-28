package com.example.android.navigation.Contactdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase(){
    abstract val databaseDao: DatabaseDAO
    companion object{
        @Volatile
        private var INSTANCE: com.example.android.navigation.Contactdatabase.Database? = null
        fun getInstance(context: Context): com.example.android.navigation.Contactdatabase.Database {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            com.example.android.navigation.Contactdatabase.Database::class.java,
                            "database"
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}