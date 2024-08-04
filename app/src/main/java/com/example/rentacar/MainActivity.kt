package com.example.rentacar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Check if user is signed in
        if (FirebaseAuth.getInstance().currentUser == null) {
            loadFragment(SignInFragment()) // Load SignInFragment
        } else {
            loadMainFragment() // Load the main fragment
        }

        setContentView(R.layout.activity_main)
        val bottomMenuOptions: Toolbar = findViewById(R.id.bottom_toolbar)
        setSupportActionBar(bottomMenuOptions)
        val topMenuOptions: Toolbar = findViewById(R.id.top_toolbar)
        setSupportActionBar(topMenuOptions)
        val homeIcon: ImageView = findViewById(R.id.ic_home)
        val addIcon: ImageView = findViewById(R.id.ic_add)
        val searchIcon: ImageView = findViewById(R.id.ic_search)
        val settingsIcon: ImageView = findViewById(R.id.ic_settings)

        // Load the default fragment
        loadFragment(HomePageFragment())

        homeIcon.setOnClickListener {
            loadFragment(HomePageFragment())
        }

        addIcon.setOnClickListener {
            loadFragment(AddVehicleFragment())
        }

        searchIcon.setOnClickListener {
            loadFragment(SearchVehicleFragment())
        }

        settingsIcon.setOnClickListener {
            loadFragment(SettingsFragment())
        }
    }

    private fun loadMainFragment() {
        loadFragment(HomePageFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        val inflater = menuInflater
        inflater.inflate(R.menu.top_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_sign_out -> {
                AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener {
                        // User is signed out
                        loadFragment(SignInFragment()) // Load SignInFragment
                    }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return super.onOptionsItemSelected(item)
//    }

}