package com.example.appblock

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val notes: List<Note>) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitle: TextView = itemView.findViewById(R.id.noteTitle)
        val noteContent: TextView = itemView.findViewById(R.id.noteContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.noteTitle.text = note.title
        holder.noteContent.text = note.content
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}
