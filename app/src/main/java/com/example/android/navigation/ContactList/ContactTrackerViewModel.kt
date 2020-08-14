package com.example.android.navigation.ContactList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.android.navigation.database.ListDatabaseDao
import kotlinx.coroutines.Job

class ContactTrackerViewModel(
        val database: ListDatabaseDao,
                              application: Application) : AndroidViewModel(application) {


    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}