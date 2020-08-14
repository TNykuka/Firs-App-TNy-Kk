package com.example.android.navigation.ContactList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.android.navigation.database.ListDatabaseDao

class ContactTrackerViewModel(
        val database: ListDatabaseDao,
                              application: Application) : AndroidViewModel(application) {

}