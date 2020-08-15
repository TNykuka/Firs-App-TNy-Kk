package com.example.android.navigation.database

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class ListRepository(private val listDatabaseDao: ListDatabaseDao) {

    val allWords: LiveData<List<ListNight>> = listDatabaseDao.getAlphabetizedLists()

    suspend fun insert(listNight: ListNight) {
        listDatabaseDao.insert(listNight)
    }
}