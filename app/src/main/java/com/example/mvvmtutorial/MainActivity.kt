package com.example.mvvmtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.mvvmtutorial.Adapter.NotesAdapter
import com.example.mvvmtutorial.database.NoteDataBase
import com.example.mvvmtutorial.databinding.ActivityMainBinding
import com.example.mvvmtutorial.models.Note
import com.example.mvvmtutorial.models.NoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var dataBase : NoteDataBase
    lateinit var viewModel: NoteViewModel
    lateinit var adapter: NotesAdapter
    lateinit var selectedNote: Note

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initializing the UI
        initUI()

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application))
            .get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this) { list ->

            list?.let {
                adapter.updateList(list)
            }
        }
    }

    private fun initUI() {
        TODO("Not yet implemented")
    }
}