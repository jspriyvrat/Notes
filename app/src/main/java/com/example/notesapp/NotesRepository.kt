package com.example.notesapp
import androidx.room.*

import androidx.lifecycle.LiveData

class NotesRepository(private  val note:MyDao)
{
     val  allNotes:LiveData<List<Notes>> =note.getAllNotes()

    suspend fun insertNote(notes: Notes)
    {
        note.insertNote(notes)
    }
    suspend fun deleteNote(notes: Notes)
    {
        note.deleteNote(notes)
    }

}