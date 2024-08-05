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

//    private lateinit var sharedPreferences: SharedPreferences
//    private lateinit var themeSpinner: Spinner
//    private lateinit var notificationSwitch: Switch
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_settings, container, false)
//
//        sharedPreferences = requireActivity().getSharedPreferences("AppSettings", Context.MODE_PRIVATE)
//
//        themeSpinner = view.findViewById(R.id.theme_spinner)
//        notificationSwitch = view.findViewById(R.id.notification_switch)
//
//        val themes = arrayOf("Light", "Dark")
//        themeSpinner.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, themes)
//        themeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                val selectedTheme = when (position) {
//                    0 -> R.style.AppTheme_Light
//                    1 -> R.style.AppTheme_Dark
//                    else -> R.style.AppTheme_Light
//                }
//                sharedPreferences.edit().putInt("theme", selectedTheme).apply()
//                requireActivity().recreate() // recreate the activity to apply the theme change
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {}
//        }
//
//        // Set the initial theme selection based on shared preferences
//        val currentTheme = sharedPreferences.getInt("theme", R.style.AppTheme_Light)
//        themeSpinner.setSelection(if (currentTheme == R.style.AppTheme_Light) 0 else 1)
//
//        notificationSwitch.isChecked = sharedPreferences.getBoolean("notifications", true)
//        notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
//            sharedPreferences.edit().putBoolean("notifications", isChecked).apply()
//            val message = if (isChecked) "Notifications enabled" else "Notifications disabled"
//            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
//        }
//        return view
//    }
}
