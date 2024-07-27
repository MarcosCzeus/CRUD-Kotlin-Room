package com.example.appblock

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val notes = mutableListOf<Note>()
    private val adapter = NotesAdapter(notes)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        fab.setOnClickListener {
            showAddNoteDialog()
        }
    }

    private fun showAddNoteDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_note, null)
        val titleEditText = dialogView.findViewById<EditText>(R.id.noteTitleEditText)
        val contentEditText = dialogView.findViewById<EditText>(R.id.noteContentEditText)

        MaterialAlertDialogBuilder(this)
            .setTitle("Add Note")
            .setView(dialogView)
            .setPositiveButton("Add") { dialog, _ ->
                val title = titleEditText.text.toString()
                val content = contentEditText.text.toString()
                if (title.isNotBlank() && content.isNotBlank()) {
                    notes.add(Note(title, content))
                    adapter.notifyItemInserted(notes.size - 1)
                }
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
