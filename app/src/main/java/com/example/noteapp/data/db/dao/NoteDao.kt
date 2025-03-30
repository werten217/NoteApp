package com.example.noteapp.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.data.models.NoteModel

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(noteModel: NoteModel)
    @Query("SELECT * FROM note_model")
    fun getAll(): LiveData<List<NoteModel>>
    @Delete
    fun deleteNote(noteModel: NoteModel)
    @Update
    fun updateNote(noteModel: NoteModel)
    @Query
        ("SELECT * FROM note_model WHERE id = :id")
    fun getNoteId(id: Int): NoteModel?




}