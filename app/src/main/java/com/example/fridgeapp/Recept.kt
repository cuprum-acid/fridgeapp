package com.example.fridgeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch

class Recept : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recept)

        val scan = findViewById<ImageView>(R.id.arrowback)
        scan.setOnClickListener{
            val randomIntent = Intent(this, GreatMenu::class.java)
            startActivity(randomIntent)
        }

        val standardSwitch: Switch = findViewById(R.id.switchheart)
        standardSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                standardSwitch.background=getResources().getDrawable(R.drawable.heart)
            }else{
                standardSwitch.background=getResources().getDrawable(R.drawable.heart)
            }
        }
    }





}