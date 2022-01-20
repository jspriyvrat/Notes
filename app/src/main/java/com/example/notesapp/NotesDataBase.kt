package com.example.notesapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Notes::class),version = 1,exportSchema = false)
abstract class NotesDataBase :RoomDatabase(){

    abstract  fun getNoteDao():MyDao


    companion object{
    private  var INSTANCE:NotesDataBase?=null


        fun getInstance(context: Context):NotesDataBase
        {
            return  INSTANCE?: synchronized(this){
                val instance=Room.databaseBuilder(context.applicationContext,NotesDataBase::class.java
                ,"mydatabase").build()
                INSTANCE=instance
                 instance
            }
        }

    }
}