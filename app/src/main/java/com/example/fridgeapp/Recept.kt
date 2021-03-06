package com.example.fridgeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView

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
                standardSwitch.background=getResources().getDrawable(R.drawable.like)
            }else{
                standardSwitch.background=getResources().getDrawable(R.drawable.like)
            }
        }

        val ing=findViewById<TextView>(R.id.ing)
        ing.setText("•Помидоры"+"\n"+"    1 штука" + "\n" + "•Сладкий перец"+"\n"+"    1 штука" + "\n" +"•Огурцы"+"\n"+"    1 штука" + "\n" +"•Репчатый лук"+"\n"+"    1 головка" + "\n" +"•Растительное масло"+ "\n"+"    15 мл")
        val rec=findViewById<TextView>(R.id.rec)
        rec.setText("1) Нарезать овощи произвольно." +"\n"+"2) Заправить растительным или оливковым маслом." +"\n" +"3) Добавить соль и перец по вкусу.")
        val tit=findViewById<TextView>(R.id.titlerec)
        tit.setText("Салат Цезарь")
    }





}