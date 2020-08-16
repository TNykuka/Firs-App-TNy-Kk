package com.example.android.navigation.Adduser

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
abstract class UserRoomDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(
                context: Context,
                scope: CoroutineScope
        ): UserRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserRoomDatabase::class.java,
                        "word_database"
                )
                        .fallbackToDestructiveMigration()
                        .addCallback(UserDatabaseCallback(scope))
                        .build()
                INSTANCE = instance
                instance
            }
        }

        private class UserDatabaseCallback(
                private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database.userDao())
                    }
                }
            }

            fun populateDatabase(userDao: UserDao) {
                userDao.deleteAll()
            }
        }
    }
}