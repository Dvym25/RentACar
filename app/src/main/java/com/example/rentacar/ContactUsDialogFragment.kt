package com.example.rentacar

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class ContactUsDialogFragment : DialogFragment(R.layout.fragment_contact) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the email and phone views
        val emailTextView: TextView = view.findViewById(R.id.contact_us_email)
        val phoneTextView: TextView = view.findViewById(R.id.contact_us_phone)
        val okButton: Button = view.findViewById(R.id.contact_us_ok_button)

        // Optionally set the email and phone number programmatically
        emailTextView.text = "Email: Test.app.rentacar@gmail.com"
        phoneTextView.text = "Phone: +1234567890"

        okButton.setOnClickListener {
            dismiss()
        }
    }
}
