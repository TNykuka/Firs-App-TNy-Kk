package com.example.android.navigation.Adduser

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao{
    @Query("SELECT * from user_table ORDER BY user ASC")
    fun getAlphabetizedUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User)

    @Query("DELETE FROM user_table")
    fun deleteAll()
}