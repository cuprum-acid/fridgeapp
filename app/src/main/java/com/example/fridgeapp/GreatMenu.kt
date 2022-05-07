package com.example.fridgeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class GreatMenu : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.greatmenu)

        val scan = findViewById<ImageView>(R.id.fridgebutton)
        scan.setOnClickListener{
            val randomIntent = Intent(this, MainActivity::class.java)
            startActivity(randomIntent)
        }
    }


}
