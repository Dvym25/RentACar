package com.example.rentacar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class AboutDialogFragment : DialogFragment(R.layout.fragment_about) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle the view components
        val messageTextView: TextView = view.findViewById(R.id.about_message)
        val okButton: Button = view.findViewById(R.id.about_ok_button)

        okButton.setOnClickListener {
            dismiss()
        }
    }
}
