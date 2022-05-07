package com.example.fridgeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*

class Letsmeet : Activity() {
    lateinit var netda :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.letsmeet)

        val check1: CheckBox = findViewById(R.id.celi)
        val check2: CheckBox = findViewById(R.id.lacto)
        val check3: CheckBox = findViewById(R.id.diabet)
        val check4: CheckBox = findViewById(R.id.vegetarian)
        val check5: CheckBox = findViewById(R.id.vegan)
        var zero = 0

        netda = findViewById(R.id.textView3)

        check1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                zero += 1
            }else  {
                zero -= 1
            }
            if (zero>0){
            netda.text="Продолжить"
        }else{
                netda.text="Нет"
            }
        }

        check2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                zero += 1
            }else  {
                zero -= 1
            }
            if (zero>0){
                netda.text="Продолжить"
            }else{
                netda.text="Нет"
            }
        }

        check3.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                zero += 1
            }else  {
                zero -= 1
            }
            if (zero>0){
                netda.text="Продолжить"
            }else{
                netda.text="Нет"
            }
        }

        check4.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                zero += 1
            }else  {
                zero -= 1
            }
            if (zero>0){
                netda.text="Продолжить"
            }else{
                netda.text="Нет"
            }
        }

        check5.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                zero += 1
            }else  {
                zero -= 1
            }
            if (zero>0){
                netda.text="Продолжить"
            }else{
                netda.text="Нет"
            }
        }

        if (zero>0){
            netda.text="Продолжить"
        }else{
            netda.text="Нет"
        }

        val scan = findViewById<ImageView>(R.id.rectangle_2)
        scan.setOnClickListener{
            val randomIntent = Intent(this, GreatMenu::class.java)
            startActivity(randomIntent)
        }
    }

}