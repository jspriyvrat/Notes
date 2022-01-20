package com.example.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Context,val listener:IvInterface): RecyclerView.Adapter<MyAdapter.NotesViewHolder>() {

    val allNotes=ArrayList<Notes>()
    inner class NotesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        val  txtview:TextView=itemView.findViewById(R.id.textView)
        val button:ImageView=itemView.findViewById(R.id.delete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):NotesViewHolder{
       val viewHolder= NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.my_row,parent,false))
        viewHolder.button.setOnClickListener {
        listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder:NotesViewHolder, position: Int) {
        val currentNote=allNotes[position]
        holder.txtview.text=currentNote.text
    }

    override fun getItemCount(): Int {
       return  allNotes.size
    }
    fun updateList(newList:ArrayList<Notes>)
    {
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}
interface IvInterface{
    fun onItemClicked(note:Notes)
}