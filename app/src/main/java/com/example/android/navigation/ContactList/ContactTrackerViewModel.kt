package com.example.android.navigation.ContactList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.navigation.database.ListDatabase
import com.example.android.navigation.database.ListDatabaseDao
import com.example.android.navigation.database.ListNight
import com.example.android.navigation.database.ListRepository
import kotlinx.coroutines.*

class ContactTrackerViewModel(application: Application) : AndroidViewModel(application) {


    private val repository: ListRepository

    val allWords: LiveData<List<ListNight>>

    init {
        val wordsDao = ListDatabase.getDatabase(application).listDatabaseDao()
        repository = ListRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(listNight: ListNight) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(listNight)
    }

}