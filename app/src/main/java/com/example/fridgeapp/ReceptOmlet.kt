package com.example.fridgeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView

class ReceptOmlet : Activity() {
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
                standardSwitch.background=getResources().getDrawable(R.drawable.like)
            }else{
                standardSwitch.background=getResources().getDrawable(R.drawable.like)
            }
        }

        val ing=findViewById<TextView>(R.id.ing)
        ing.setText("•Яйца"+ "\n" + "•Молоко"+ "\n" +"•Помидоры"+ "\n" + "\n" +"•Оливковое масло"+ "\n"+"    6 г")
        val rec=findViewById<TextView>(R.id.rec)
        rec.setText("1) Помидоры необходимо от бланшировать крутым кипятком и снять кожицу." +"\n"+"2) Чистим яица и добавляем на сковородку, смазанную маслом"+"\n"+"3) Жарить омлет чуть ниже, чем на среднем огне, обязательно накрыть крышкой и желательно не открывать до полного приготовления омлета.")
        val tit=findViewById<TextView>(R.id.titlerec)
        tit.setText("Омлет")
    }





}