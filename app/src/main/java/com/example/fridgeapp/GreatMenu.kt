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

        val ceaser = findViewById<ImageView>(R.id.ceaser)
        ceaser.setOnClickListener{
            val randomIntent = Intent(this, Recept::class.java)
            startActivity(randomIntent)
        }

        val bs = findViewById<ImageView>(R.id.breadsoup)
        bs.setOnClickListener{
            val randomIntent = Intent(this, ReceptSoup::class.java)
            startActivity(randomIntent)
        }

        val o = findViewById<ImageView>(R.id.omlet)
        o.setOnClickListener{
            val randomIntent = Intent(this, ReceptOmlet::class.java)
            startActivity(randomIntent)
        }
    }


}
