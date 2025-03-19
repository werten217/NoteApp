package com.example.noteapp.models

import java.io.Serializable

data class OnBoardModel(
    val imageView: String,
    val title: String,
    val description: String
) : Serializable
