package com.example.rentacar

import android.app.Activity
import android.content.Context
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.auth.result.AuthSignInResult
import com.amplifyframework.core.Amplify

object Backend {

    private const val TAG = "Backend"

    fun initialize(applicationContext: Context): Backend {
        try {
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Amplify.configure(applicationContext)
            Log.i(TAG, "Initialized Amplify")
        } catch (e: AmplifyException) {
            Log.e(TAG, "Could not initialize Amplify", e)
        }

        return this
    }

    private fun updateUserData(withSignedInStatus: Boolean) {
        // Replace with appropriate logic to update user data
        // UserData.setSignedIn(withSignedInStatus)
    }

    fun signOut() {
        Log.i(TAG, "Initiate Signout Sequence")

        Amplify.Auth.signOut(
            { Log.i(TAG, "Signed out!") },
            { error -> Log.e(TAG, error.toString()) }
        )
    }

    fun signIn(callingActivity: Activity) {
        Log.i(TAG, "Initiate Signin Sequence")

        Amplify.Auth.signInWithWebUI(
            callingActivity,
            { result: AuthSignInResult -> Log.i(TAG, result.toString()) },
            { error: AuthException -> Log.e(TAG, error.toString()) }
        )
    }
}
