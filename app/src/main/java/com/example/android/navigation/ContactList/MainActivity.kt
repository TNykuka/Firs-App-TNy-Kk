package com.example.android.navigation.ContactList

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.android.navigation.R

class MainActivity : AppCompatActivity() {

    val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
    val adapter = ContactListFragment(this)
    recyclerView.adapter = adapter
    recyclerView.layoutManager = LinearLayoutManager(this)
}