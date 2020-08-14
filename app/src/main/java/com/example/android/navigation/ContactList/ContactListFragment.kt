package com.example.android.navigation.ContactList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.android.navigation.R
import com.example.android.navigation.database.ListDatabase
import com.example.android.navigation.databinding.FragmentContactListBinding

class ContactListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentContactListBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_contact_list, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = ListDatabase.getInstance(application).ListDatabaseDao
        val viewModelFactory = ContactListTrackerViewModelFactory(dataSource, application)

        val listTrackerViewModel =
                ViewModelProvider(
                        this, viewModelFactory).get(ContactTrackerViewModel::class.java)

        // Inflate the layout for this fragment
        binding.setLifecycleOwner(this)
        binding.listTrackerViewModel = listTrackerViewModel

        return binding.root
    }
}