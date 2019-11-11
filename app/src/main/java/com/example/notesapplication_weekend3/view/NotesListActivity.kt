package com.example.notesapplication_weekend3.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapplication_weekend3.MyDatabase
import com.example.notesapplication_weekend3.R
import com.example.notesapplication_weekend3.adapter.NotesAdapter
import com.example.notesapplication_weekend3.view.AddNotesActivity.Companion.db
import kotlinx.android.synthetic.main.activity_add_notes.*
import kotlinx.android.synthetic.main.activity_notes_list.*
import kotlinx.android.synthetic.main.notes_item_view.*

class NotesListActivity : AppCompatActivity() {

    var notesList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)


        readFromDatabase()
       // applyThemeColor()
        addNote_icon.setOnClickListener {
            val intent = Intent(this,AddNotesActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        readFromDatabase()
    }

    private fun readFromDatabase(){
        notesList.clear()

        val cursor = db.readAllNotes()

        cursor.moveToFirst()

        if (cursor.count > 0) {
            val note = cursor.getString(cursor.getColumnIndex(MyDatabase.COLUMN_CONTENT))
            notesList.add(note)
        }


        while (cursor.moveToNext()) {
            val note = cursor.getString(cursor.getColumnIndex(MyDatabase.COLUMN_CONTENT))
            notesList.add(note)
        }

        displayNotes()

    }

    private fun displayNotes(){
        val recyclerAdapter = NotesAdapter(notesList)
        notes_listView.adapter = recyclerAdapter
        notes_listView.layoutManager = LinearLayoutManager(this)
    }

    private fun applyThemeColor() {
        val colorValue = MainActivity.sharedPreferences.getString("Color", "FAILED")

        when (colorValue) {

            "Purple" -> note_textView.setTextColor(Color.parseColor("#51417C"))
            "Green" -> note_textView.setTextColor(Color.parseColor("#00ff00"))
            "Red" -> note_textView.setTextColor(Color.parseColor("#FF0000"))
            "Yellow" -> note_textView.setTextColor(Color.parseColor("#ffff00"))
            "Blue" -> note_textView.setTextColor(Color.parseColor("#0000ff"))
            "Orange" -> note_textView.setTextColor(Color.parseColor("#ffa500"))
            "Light-Blue" -> note_textView.setTextColor(Color.parseColor("#add8e6"))
            "Dark-Green" -> note_textView.setTextColor(Color.parseColor("#013220"))
            "Magenta" -> note_textView.setTextColor(Color.parseColor("#FF00FF"))
            "Dark-Skin" -> note_textView.setTextColor(Color.parseColor("#9c7248"))
        }
    }
}
