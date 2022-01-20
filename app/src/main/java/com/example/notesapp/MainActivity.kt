package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), IvInterface {
    lateinit var viewModel: MyViewModel
    lateinit var recyler:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyler=findViewById(R.id.myrecyler)

        recyler.layoutManager=LinearLayoutManager(this)
        val adapter=MyAdapter(this,this)
        recyler.adapter=adapter

        viewModel=ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(MyViewModel::class.java)
            viewModel.allNotes.observe(this, Observer {
            adapter.updateList(it as ArrayList<Notes>)
            })

    }

    override fun onItemClicked(note: Notes) {
        viewModel.deleteNote(note)
    }
}