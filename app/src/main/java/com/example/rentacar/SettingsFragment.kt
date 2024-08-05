package com.example.rentacar

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Switch
import android.widget.Toast
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private lateinit var notificationSwitch: Switch
    private lateinit var themeSpinner: Spinner
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        // Initialize SharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

        // Initialize UI elements
        notificationSwitch = view.findViewById(R.id.notification_switch)
        themeSpinner = view.findViewById(R.id.theme_spinner)

        // Set up the Switch
        val notificationsEnabled = sharedPreferences.getBoolean("notificationsEnabled", false)
        notificationSwitch.isChecked = notificationsEnabled
        notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit().putBoolean("notificationsEnabled", isChecked).apply()
            Toast.makeText(context, if (isChecked) "Notifications Enabled" else "Notifications Disabled", Toast.LENGTH_SHORT).show()
        }

        // Set up the Spinner
        val themeOptions = arrayOf("Light", "Dark", "System Default")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, themeOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        themeSpinner.adapter = adapter

        val savedTheme = sharedPreferences.getString("selectedTheme", "System Default")
        themeSpinner.setSelection(themeOptions.indexOf(savedTheme))

        themeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedTheme = themeOptions[position]
                sharedPreferences.edit().putString("selectedTheme", selectedTheme).apply()
                Toast.makeText(context, "Theme Selected: $selectedTheme", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case where no item is selected
            }
        }

        return view
    }
}
