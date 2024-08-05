package com.example.rentacar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.Toast
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val notificationSwitch: Switch = view.findViewById(R.id.notification_switch)

        notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(context, "Notifications Enabled", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Notifications Disabled", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
