package com.example.notesapp
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes_table")
data class Notes(val text :String )
{
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}