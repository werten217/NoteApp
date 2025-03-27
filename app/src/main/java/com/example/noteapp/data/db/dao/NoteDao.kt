package com.example.noteapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.noteapp.data.models.NoteModel

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(noteModel: NoteModel)
    @Query("SELECT * FROM note_model")
    fun getAll(): LiveData<List<NoteModel>>
}