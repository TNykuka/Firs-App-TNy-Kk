package com.example.android.navigation.Contact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.android.navigation.Contactdatabase.DatabaseDAO
import com.example.android.navigation.databinding.FragmentContactBinding

class ContactViewModel(
        val database: DatabaseDAO,
        private val binding: FragmentContactBinding,
        application: Application
) : AndroidViewModel(application) {
}