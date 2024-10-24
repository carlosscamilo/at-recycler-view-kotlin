package com.example.at_david_recycler_view

import androidx.recyclerview.widget.RecyclerView
import com.example.at_david_recycler_view.databinding.ItemLayoutBinding

class PersonViewHolder(private val personBiding: ItemLayoutBinding) : RecyclerView.ViewHolder(personBiding.root) {
    fun bind(person: Person) {
        personBiding.name.text = person.name
        personBiding.age.text = person.age.toString()
        personBiding.profession.text = person.profession
    }
}