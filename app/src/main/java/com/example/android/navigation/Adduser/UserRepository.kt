package com.example.android.navigation.Adduser

import androidx.lifecycle.LiveData

class UserRepository(private val wordDao: UserDao) {

    val allWords: LiveData<List<Usar>> = wordDao.getAlphabetizedUsers()

    suspend fun insert(user : Usar) {
        wordDao.insert(user)
    }
}