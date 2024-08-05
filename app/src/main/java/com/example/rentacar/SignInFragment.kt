package com.example.rentacar

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth

class SignInFragment : Fragment() {

    private val RC_SIGN_IN = 123 // Request code for sign-in

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        val signInButton: Button = view.findViewById(R.id.btn_sign_in)
        signInButton.setOnClickListener {
            startSignIn()
        }

        return view
    }

    private fun startSignIn() {
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(listOf(
                AuthUI.IdpConfig.EmailBuilder().build(),
                AuthUI.IdpConfig.GoogleBuilder().build()
            ))
            .build()
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser

                (activity as MainActivity).loadMainFragment()
            } else {
                // Sign-in failed
                Toast.makeText(context, "Sign-in failed: ${response?.error?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
