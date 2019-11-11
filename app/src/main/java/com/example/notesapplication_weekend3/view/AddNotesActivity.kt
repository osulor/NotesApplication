package com.example.notesapplication_weekend3.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notesapplication_weekend3.MyDatabase
import com.example.notesapplication_weekend3.R
import kotlinx.android.synthetic.main.activity_add_notes.*

class AddNotesActivity : AppCompatActivity() {

    companion object{
       lateinit var db: MyDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        db = MyDatabase(this)

        applyThemeColor()

        save_button.setOnClickListener {
            saveToDatabase()
            val intent = Intent(this,NotesListActivity::class.java)
            startActivity(intent)
        }

        goToNotes_button.setOnClickListener{
            val intent = Intent(this,NotesListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun applyThemeColor(){
        val colorValue = MainActivity.sharedPreferences.getString("Color","FAILED")

        when(colorValue){

            "Purple" -> note_text.setTextColor(Color.parseColor("#51417C"))
            "Green" -> note_text.setTextColor(Color.parseColor("#00ff00"))
            "Red"   -> note_text.setTextColor(Color.parseColor("#FF0000"))
            "Yellow" -> note_text.setTextColor(Color.parseColor("#ffff00"))
            "Blue" -> note_text.setTextColor(Color.parseColor("#0000ff"))
            "Orange" -> note_text.setTextColor(Color.parseColor("#ffa500"))
            "Light-Blue" -> note_text.setTextColor(Color.parseColor("#add8e6"))
            "Dark-Green" -> note_text.setTextColor(Color.parseColor("#013220"))
            "Magenta" -> note_text.setTextColor(Color.parseColor("#FF00FF"))
            "Dark-Skin" -> note_text.setTextColor(Color.parseColor("#9c7248"))


        }
    }

    private fun saveToDatabase(){
        val noteContent = note_text.text.toString()
        db.insert(noteContent)
        note_text.text.clear()
        Toast.makeText(this,"Note successfully saved !",Toast.LENGTH_LONG).show()
    }


}
