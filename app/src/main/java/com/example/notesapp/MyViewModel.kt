package com.example.notesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MyViewModel(application: Application):AndroidViewModel(application) {
    val allNotes:LiveData<List<Notes>>
    val repository:NotesRepository
    init {
        val dao=NotesDataBase.getInstance(application).getNoteDao()
        repository=NotesRepository(dao)
        allNotes=repository.allNotes
    }

    fun deleteNote(note:Notes)=  viewModelScope.launch(Dispatchers.IO){
        repository.deleteNote(note)
    }
    fun insertNote(note:Notes)=  viewModelScope.launch(Dispatchers.IO){
        repository.insertNote(note)
    }
}