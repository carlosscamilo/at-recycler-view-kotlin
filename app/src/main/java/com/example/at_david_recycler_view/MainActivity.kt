package com.example.at_david_recycler_view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.at_david_recycler_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val persons = mutableListOf<Person>()
    private var personAdapter : PersonAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        personAdapter = PersonAdapter(persons)
        binding.recyclerView.adapter = personAdapter

        binding.buttonAdd.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val age = binding.editTextAge.text.toString().toInt()
            val profession = binding.editTextProfession.text.toString()

            if (name.isEmpty() || age == 0 || profession.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val person = Person(name, age, profession)

            persons.add(person)
            personAdapter?.notifyItemInserted(persons.size - 1)
        }
    }
}