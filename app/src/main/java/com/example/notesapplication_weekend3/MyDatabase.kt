package com.example.notesapplication_weekend3

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabase(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION,null){

    companion object{
        const val DATABASE_NAME = "customers.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "notes"
        const val NOTE_ID = "note_id"
        const val COLUMN_CONTENT ="content"
    }

    override fun onCreate(db: SQLiteDatabase) {

        val createStatement ="CREATE TABLE $TABLE_NAME ($NOTE_ID INTEGER PRIMARY KEY, $COLUMN_CONTENT TEXT)"
        db.execSQL(createStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insert(newNote: String){

        val noteValues = ContentValues()
        noteValues.put(COLUMN_CONTENT,newNote)

        val db = writableDatabase
        db.insert(TABLE_NAME,null,noteValues)
        db.close()
    }

    fun readAllNotes(): Cursor{
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"

       return db.rawQuery(query,null)
    }



}