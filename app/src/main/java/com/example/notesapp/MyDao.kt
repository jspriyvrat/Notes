package com.example.notesapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insertNote(notes: Notes)

    @Delete
   suspend fun deleteNote(notes: Notes)

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun  getAllNotes():LiveData<List<Notes>>
}