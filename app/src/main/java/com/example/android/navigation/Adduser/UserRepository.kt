package com.example.android.navigation.Adduser

import androidx.lifecycle.LiveData

class UserRepository(private val wordDao: UserDao) {

    val allUsers: LiveData<List<User>> = wordDao.getAlphabetizedUsers()

    fun insert(user : User) {
        wordDao.insert(user)
    }
}