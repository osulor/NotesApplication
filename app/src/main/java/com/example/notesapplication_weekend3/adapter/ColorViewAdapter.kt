package com.example.notesapplication_weekend3.adapter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapplication_weekend3.R
import com.example.notesapplication_weekend3.view.AddNotesActivity
import com.example.notesapplication_weekend3.view.MainActivity


class ColorViewAdapter(val colorArray: List<String>) : RecyclerView.Adapter<ColorViewAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.color_list_item,parent,false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return colorArray.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        val colorValue = colorArray[position]

        holder.apply {

            color.text = colorArray[position]

            when(colorValue){

                "Purple" -> color.setBackgroundColor(Color.parseColor("#51417C"))
                "Green" -> color.setBackgroundColor(Color.parseColor("#00ff00"))
                "Red"   -> color.setBackgroundColor(Color.parseColor("#FF0000"))
                "Yellow" -> color.setBackgroundColor(Color.parseColor("#ffff00"))
                "Blue" -> color.setBackgroundColor(Color.parseColor("#0000ff"))
                "Orange" -> color.setBackgroundColor(Color.parseColor("#ffa500"))
                "Light-Blue" -> color.setBackgroundColor(Color.parseColor("#add8e6"))
                "Dark-Green" -> color.setBackgroundColor(Color.parseColor("#013220"))
                "Magenta" -> color.setBackgroundColor(Color.parseColor("#FF00FF"))
                "Dark-Skin" -> color.setBackgroundColor(Color.parseColor("#9c7248"))
            }
        }

        holder.itemView.setOnClickListener {

            MainActivity.editorSharedPreferences.putString("Color",colorArray[position])
            MainActivity.editorSharedPreferences.commit()

           // Log.d("TAG", MainActivity.sharedPreferences.getString("Color","FAILED") + " has been clicked")
            val intent = Intent(it.context,AddNotesActivity::class.java)
            it.context.startActivity(intent)
        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val color = itemView.findViewById<TextView>(R.id.color_textView)
    }

}