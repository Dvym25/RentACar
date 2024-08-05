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
import com.squareup.picasso.Picasso

class HomePageFragment : Fragment(R.layout.homepage) {

    private lateinit var greetingsText: TextView
    private lateinit var profilePic: ImageView
    private lateinit var userPhone: TextView
    private lateinit var userEmail: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.homepage, container, false)
        greetingsText = view.findViewById(R.id.greetings)
        profilePic = view.findViewById(R.id.profilePic)
        userPhone = view.findViewById(R.id.user_phone)
        userEmail = view.findViewById(R.id.user_email)

        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            userPhone.text = user.phoneNumber ?: "NOT PROVIDED"

            userEmail.text = user.email ?: "NOT PROVIDED"

            user.photoUrl?.let {
                Picasso.get().load(it).into(profilePic)
            }
            val userName = user.displayName ?: "User"
            greetingsText.text = "Welcome, $userName!"
            Log.d("ProfilePic", "Photo URL: ${user.photoUrl}")
        } else {
            showSignInFragment()
        }

        return view
    }

    private fun showSignInFragment() {
        val fragmentManager = parentFragmentManager
        val signInFragment = SignInFragment()

        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, signInFragment)
            .addToBackStack(null)
            .commit()
    }
}
