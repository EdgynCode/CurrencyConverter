package com.currencyconverter.controllers

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.currencyconverter.R

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private lateinit var switchOfflineMode: SwitchCompat

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        switchOfflineMode = view.findViewById(R.id.switchOfflineMode)

        // Retrieve and set the current state of offline mode from SharedPreferences
        val sharedPreferences = requireContext().getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        val isOfflineModeEnabled = sharedPreferences.getBoolean("offline_mode", false)
        switchOfflineMode.isChecked = isOfflineModeEnabled

        // Set listener for the switch
        switchOfflineMode.setOnCheckedChangeListener { _, isChecked ->
            // Save the new state to SharedPreferences
            sharedPreferences.edit().putBoolean("offline_mode", isChecked).apply()

            // Show a toast message indicating the change
            val message = if (isChecked) "Offline mode enabled" else "Offline mode disabled"
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }
}