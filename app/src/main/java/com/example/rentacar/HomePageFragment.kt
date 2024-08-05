package com.example.rentacar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth

class HomePageFragment : Fragment(R.layout.homepage) {

    private lateinit var greetingsText: TextView
    private lateinit var profilePic: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.homepage, container, false)
        greetingsText = view.findViewById(R.id.greetings)
        profilePic = view.findViewById(R.id.profilePic)

        // Get the current user from FirebaseAuth
        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            profilePic.setImageURI(user.photoUrl)
        }

        // Check if user is not null and set the greeting text
        if (user != null) {
            val userName = user.displayName ?: "User"
            greetingsText.text = "Welcome, $userName!"
            Log.d("ProfilePic", "Photo URL: ${user.photoUrl}")

        } else {
            greetingsText.text = "Welcome!"
        }

        return view
    }
}
