package com.app.social_m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = this.findNavController(R.id.nav_host_fragment)


        navController.addOnDestinationChangedListener { _, destination, _ ->
           if (destination.id == R.id.userDetailsFragment) {
               Toast.makeText(this , "ChangedToUserDetails" , Toast.LENGTH_SHORT ).show()
           }
           else {
               Toast.makeText(this , "BackToUsers" , Toast.LENGTH_SHORT ).show()
           }
        }


    }
}