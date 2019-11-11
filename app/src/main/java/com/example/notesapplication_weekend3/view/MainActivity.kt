package com.example.notesapplication_weekend3.view

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapplication_weekend3.R
import com.example.notesapplication_weekend3.adapter.ColorViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var sharedPreferences: SharedPreferences
        lateinit var editorSharedPreferences: SharedPreferences.Editor
    }
    val colorArray = listOf("Green","Blue","Red","Purple","Yellow","Orange","Light-Blue","Dark-Green","Magenta","Dark-Skin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("com.example.notesapplication_weekend3.view",Context.MODE_PRIVATE)
        editorSharedPreferences = sharedPreferences.edit()

        displayColors()

    }


    private fun displayColors(){

        val recyclerAdapter = ColorViewAdapter(colorArray)
//        color_listView.adapter = recyclerAdapter
//        color_listView.layoutManager = LinearLayoutManager(this)
        colorListView.adapter = recyclerAdapter
        colorListView.layoutManager =LinearLayoutManager(this)
    }
}
