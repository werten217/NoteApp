package com.example.noteapp.ui.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper  {
    private lateinit var sharedPreferences: SharedPreferences
    fun init(context: Context){
        sharedPreferences= context.getSharedPreferences("shared",Context.MODE_PRIVATE)
    }
    var isOnBoard: Boolean
        get() = sharedPreferences.getBoolean("onboard",false)
        set(value) = sharedPreferences.edit().putBoolean("onboard",value).apply()
}