package com.example.fridgeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class Start : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.startscreen)

        val scan = findViewById<ImageView>(R.id.applebutton)
        scan.setOnClickListener{
            val randomIntent = Intent(this, Letsmeet::class.java)
            startActivity(randomIntent)
        }
    }

}