package com.example.noteapp

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.noteapp.data.db.AppDatabase
import com.example.noteapp.ui.utils.PreferenceHelper

class App : Application(){

    companion object{
        var appDatabase: AppDatabase? = null
    }


    override fun onCreate() {
        super.onCreate()
        val shared = PreferenceHelper()
        shared.init(this)
        GetInstance()
    }

    private fun GetInstance(): AppDatabase? {
        if (appDatabase == null) {
            appDatabase = applicationContext?.let { context ->
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "database-note"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }


        return appDatabase}}





