package com.example.android.navigation.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ListDatabaseDao{

    @Insert
    suspend fun insertSubscriber(subscriber: ListNight) : Long

    @Update
    suspend fun updateSubscriber(subscriber: ListNight) : Int


    @Query("DELETE FROM daily_list_quality_table")
    suspend fun deleteAll() : Int

    @Query("SELECT * FROM daily_list_quality_table")
    fun getAllSubscribers():LiveData<List<ListNight>>
}