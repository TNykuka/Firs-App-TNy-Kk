package com.example.android.navigation.ContactList

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.android.navigation.database.ListDatabaseDao
import com.example.android.navigation.database.ListNight
import kotlinx.coroutines.*

class ContactTrackerViewModel(
        val database: ListDatabaseDao,
                              application: Application) : AndroidViewModel(application) {


    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private var tonight = MutableLiveData<ListNight?>()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        initializeTonight()
    }

    private fun initializeTonight() {
        uiScope.launch {
            tonight.value = getTonightFromDatabase()
        }
    }

    private suspend fun getTonightFromDatabase(): ListNight? {
        return withContext(Dispatchers.IO) {
            var night = database.getTonight()

            night
        }
    }

    fun onStartTracking(){
        uiScope.launch {
            val newNight = ListNight()
            insert(newNight)
        }
    }

    private suspend fun insert(newNight: ListNight) {
        withContext(Dispatchers.IO) {
            database.insert(newNight)
        }
    }

}