package com.example.android.navigation.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ListDatabaseDao{

    @Insert
    fun insert(night: ListNight)

    @Update
    fun update(night: ListNight)

    @Query("SELECT * from daily_list_quality_table WHERE namelistId= :key")
    fun get(key: Long): ListNight?

    @Query("DELETE FROM daily_list_quality_table")
    fun clear()

    @Query("SELECT * FROM daily_list_quality_table ORDER BY namelistId DESC LIMIT 1")
    fun getTonight(): ListNight?

    @Query("SELECT * FROM daily_list_quality_table ORDER BY namelistId DESC")
    fun getAllNights(): LiveData<List<ListNight>>
}