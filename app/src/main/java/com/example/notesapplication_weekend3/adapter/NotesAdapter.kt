package com.example.notesapplication_weekend3.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapplication_weekend3.R
import com.example.notesapplication_weekend3.view.MainActivity
import kotlinx.android.synthetic.main.activity_add_notes.*

class NotesAdapter(val notesList: List<String>): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_item_view,parent,false)

        return NotesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {

        holder.apply {
            note.text = notesList[position]
            val colorValue = MainActivity.sharedPreferences.getString("Color","FAILED")

            when(colorValue){

                "Purple" -> note.setTextColor(Color.parseColor("#51417C"))
                "Green" -> note.setTextColor(Color.parseColor("#00ff00"))
                "Red"   -> note.setTextColor(Color.parseColor("#FF0000"))
                "Yellow" -> note.setTextColor(Color.parseColor("#ffff00"))
                "Blue" -> note.setTextColor(Color.parseColor("#0000ff"))
                "Orange" -> note.setTextColor(Color.parseColor("#ffa500"))
                "Light-Blue" -> note.setTextColor(Color.parseColor("#add8e6"))
                "Dark-Green" -> note.setTextColor(Color.parseColor("#013220"))
                "Magenta" -> note.setTextColor(Color.parseColor("#FF00FF"))
                "Dark-Skin" -> note.setTextColor(Color.parseColor("#9c7248"))


            }
        }
    }


    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val note = itemView.findViewById<TextView>(R.id.note_textView)
    }
}