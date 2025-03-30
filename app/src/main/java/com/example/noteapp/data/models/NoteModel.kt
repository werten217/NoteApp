package com.example.noteapp.data.models

import android.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_model")
data class NoteModel(
    val title: String,
    val description: String
   ){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}


