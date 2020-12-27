package com.app.social_m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.findNavController
import com.app.social_m.fragments.UsersFragment
import com.google.android.material.appbar.MaterialToolbar


class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivityClass"
    }

    private lateinit var toolbar :MaterialToolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = this.findNavController(R.id.nav_host_fragment)
        toolbar = findViewById(R.id.material_ToolBar)

        navController.addOnDestinationChangedListener { _, destination, _ ->
           if (destination.id == R.id.userDetailsFragment) {
               toolbar.title = "UsersDetails"
           }
           else {
               toolbar.title = "User"
           }
        }


    }

}