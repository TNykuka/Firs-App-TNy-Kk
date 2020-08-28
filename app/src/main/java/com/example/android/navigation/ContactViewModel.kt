package com.example.android.navigation

import android.app.Application
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.example.android.navigation.Contactdatabase.Contact
import com.example.android.navigation.Contactdatabase.DatabaseDAO
import com.example.android.navigation.databinding.FragmentContactBinding
import kotlinx.coroutines.*
import java.lang.StringBuilder

class ContactViewModel(
        private val database: DatabaseDAO,
        private val binding: FragmentContactBinding,
        application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val contacts = database.get()
    val contactString = Transformations.map(contacts) { contacts ->
        formatContact(contacts)
    }

    private fun formatContact(contact: List<Contact>): Spanned {
        val sb = StringBuilder()
        sb.apply {
            contact.forEach {
                append("ID : ")
                append(it.id)
                append("<br>")
                append("Name : ")
                append(it.name)
                append("<br>")
                append("numberphone : ")
                append(it.phone)
                append("<br>")
                append("email : ")
                append(it.e_mail)
                append("<br>")
                append("<br>")
            }
        }
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
        } else {
            HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun onContactAdd() {
        uiScope.launch {
            val newContact = Contact()
            newContact.name = binding.editTextTextPersonName.text.toString()
            newContact.phone = binding.editTextTextPersonPhone.text.toString()
            newContact.e_mail = binding.editTextTextPersonEmail.text.toString()
            insert(newContact)
        }
    }

    private suspend fun insert(contact: Contact) {
        withContext(Dispatchers.IO) {
            database.insert(contact)
        }
    }

}