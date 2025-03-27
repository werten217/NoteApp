package com.example.noteapp.ui.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.noteapp.R
import com.example.noteapp.ui.utils.PreferenceHelper

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val shared = PreferenceHelper()
        shared.init(this)

        val graph = navController.navInflater.inflate(R.navigation.nav_graph)
        graph.setStartDestination(
        if (shared.isOnBoard == true) R.id.noteFragment else R.id.onBoardingFragment)
        navController.graph = graph
    }
}