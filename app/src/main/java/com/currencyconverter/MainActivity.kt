package com.currencyconverter

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.currencyconverter.controllers.ConvertFragment
import com.currencyconverter.controllers.LiveExchangeRatesFragment
import com.currencyconverter.controllers.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.navhost_fragment, fragment)
            .commit()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navhost_fragment)
//
//        // Check if navHostFragment is null before casting
//        if (navHostFragment is NavHostFragment) {
//            val navController = navHostFragment.navController
//            val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
//            bottomNavigationView.setupWithNavController(navController)
//        } else {
//            // Handle the error appropriately, e.g., log an error or show a message
//            Log.e("MainActivity", "NavHostFragment is null. Please check your layout and navigation setup.")
//        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        loadFragment(ConvertFragment())

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.convertFragment -> loadFragment(ConvertFragment())
                R.id.liveExchangeRatesFragment -> loadFragment(LiveExchangeRatesFragment())
                R.id.settingsFragment -> loadFragment(SettingsFragment())
            }
            true
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}