package com.example.android.navigation.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ListDatabaseDao{

    @Query("SELECT * from daily_list_quality_table ORDER BY list_name ASC")
    fun getAlphabetizedLists(): LiveData<List<ListNight>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(listNight: ListNight)

    @Query("DELETE FROM daily_list_quality_table")
    suspend fun deleteAll()
}