package com.jenius.travel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSignIn.setOnClickListener {
            // do something when button sign in is clicked
            val username = inputUsername.text.toString()

            Toast.makeText(this, "Hello ${username}, welcome back!",
                Toast.LENGTH_LONG).show()
        }
    }
}