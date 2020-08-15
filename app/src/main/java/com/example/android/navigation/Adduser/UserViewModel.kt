package com.example.android.navigation.Adduser

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository

    val allWords: LiveData<List<Usar>>

    init {
        val usersDao = UserRoomDatabase.getDatabase(application).wordDao()
        repository = UserRepository(usersDao)
        allWords = repository.allWords
    }


    fun insert(user : Usar) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(user)
    }
}