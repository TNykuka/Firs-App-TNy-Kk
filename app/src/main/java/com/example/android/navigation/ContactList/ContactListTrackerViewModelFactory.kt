package com.example.android.navigation.ContactList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.navigation.database.ListDatabaseDao
import com.example.android.navigation.database.ListNight

class ContactListTrackerViewModelFactory(private val dao : ListDatabaseDao) {

    val subscribers = dao.getAllSubscribers()

    suspend fun insert(subscriber: ListNight):Long{
        return dao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: ListNight):Int{
        return dao.updateSubscriber(subscriber)
    }

}
