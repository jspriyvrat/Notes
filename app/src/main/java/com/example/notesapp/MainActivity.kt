package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
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
            viewModel.allNotes.observe(this,Observer{
                list-> list?.let {
                    adapter.updateList(it)
            }
            })

    }

    override fun onItemClicked(note: Notes) {
        viewModel.deleteNote(note)
        Toast.makeText(applicationContext,"the item deleted is "+note.text,Toast.LENGTH_LONG).show()
    }

    fun submitData(view: View) {
        val btn: Button =findViewById(R.id.btn)
        val noteText=btn.text.toString()
        if (noteText.isNotEmpty())
        {
            viewModel.insertNote(Notes(noteText))
            Toast.makeText(this,"the item deleted is $noteText ",Toast.LENGTH_LONG).show()
        }
    }
}