package com.example.android.navigation.ContactList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.navigation.R
import com.example.android.navigation.database.ListNight

class ContactListFragment internal constructor(
        context: Context
) : RecyclerView.Adapter<ContactListFragment.ContactViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var lists = emptyList<ListNight>()

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = inflater.inflate(R.layout.fragment_contact_list, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val current = lists[position]
        holder.wordItemView.text = current.name
    }

    internal fun setWords(lists: List<ListNight>) {
        this.lists = lists
        notifyDataSetChanged()
    }

    override fun getItemCount() = lists.size
}