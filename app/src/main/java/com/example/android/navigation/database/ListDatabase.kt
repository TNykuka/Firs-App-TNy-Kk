package com.example.android.navigation.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ListNight::class],version = 1)
abstract class ListDatabase : RoomDatabase() {

    abstract val listDatabaseDao : ListDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE : ListDatabase? = null
        fun getInstance(context: Context):ListDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            ListDatabase::class.java,
                            "subscriber_data_database"
                    ).build()
                }
                return instance
            }
        }

    }
}