package com.example.rentacar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (FirebaseAuth.getInstance().currentUser == null) {
            loadFragment(SignInFragment())
        } else {
            loadMainFragment()
        }

        setContentView(R.layout.activity_main)
        val bottomMenuOptions: Toolbar = findViewById(R.id.bottom_toolbar)
        setSupportActionBar(bottomMenuOptions)
        val topMenuOptions: Toolbar = findViewById(R.id.top_toolbar)
        setSupportActionBar(topMenuOptions)

        findViewById<ImageView>(R.id.ic_home).setOnClickListener {
            loadFragment(HomePageFragment())
        }

        findViewById<ImageView>(R.id.ic_add).setOnClickListener {
            loadFragment(AddVehicleFragment())
        }

        findViewById<ImageView>(R.id.ic_search).setOnClickListener {
            loadFragment(SearchVehicleFragment())
        }

        findViewById<ImageView>(R.id.ic_settings).setOnClickListener {
            loadFragment(SettingsFragment())
        }
    }

    public fun loadMainFragment() {
        loadFragment(HomePageFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sign_out -> {
                AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener {
                        loadFragment(SignInFragment())
                    }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
