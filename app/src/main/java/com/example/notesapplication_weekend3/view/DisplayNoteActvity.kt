package com.example.notesapplication_weekend3.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notesapplication_weekend3.R
import kotlinx.android.synthetic.main.activity_display_note_actvity.*
import kotlinx.android.synthetic.main.notes_item_view.*

class DisplayNoteActvity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_note_actvity)

        applyThemeColor()
      val content =  intent.getStringExtra("NoteContent")
       display_textView.text = content.toString()

    }

    private fun applyThemeColor() {
        val colorValue = MainActivity.sharedPreferences.getString("Color", "FAILED")

        when (colorValue) {

            "Purple" -> display_textView.setTextColor(Color.parseColor("#51417C"))
            "Green" -> display_textView.setTextColor(Color.parseColor("#00ff00"))
            "Red" -> display_textView.setTextColor(Color.parseColor("#FF0000"))
            "Yellow" -> display_textView.setTextColor(Color.parseColor("#ffff00"))
            "Blue" -> display_textView.setTextColor(Color.parseColor("#0000ff"))
            "Orange" -> display_textView.setTextColor(Color.parseColor("#ffa500"))
            "Light-Blue" -> display_textView.setTextColor(Color.parseColor("#add8e6"))
            "Dark-Green" -> display_textView.setTextColor(Color.parseColor("#013220"))
            "Magenta" -> display_textView.setTextColor(Color.parseColor("#FF00FF"))
            "Dark-Skin" -> display_textView.setTextColor(Color.parseColor("#9c7248"))
        }
    }
}
