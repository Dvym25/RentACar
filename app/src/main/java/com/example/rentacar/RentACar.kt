package com.example.rentacar

import android.app.Application
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.Amplify

class RentACar : Application() {
    override fun onCreate() {
        super.onCreate()
        try {
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Amplify.configure(applicationContext)
            Log.i("RentACar", "Initialized Amplify")
        } catch (e: AmplifyException) {
            Log.e("RentACar", "Could not initialize Amplify", e)
        }
    }
}
