package com.example.android.navigation.Adduser

import androidx.lifecycle.LiveData

class UserRepository(private val wordDao: UserDao) {

    val allWords: LiveData<List<User>> = wordDao.getAlphabetizedUsers()

    suspend fun insert(user : User) {
        wordDao.insert(user)
    }
}