package com.example.fridgeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView

class ReceptSoup : Activity() {
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
        ing.setText("•Хлеб"+"\n"+"    6 ломтиков" + "\n" + "•Яйцо"+"\n"+"    6 штук" + "\n" +"•Огурцы"+"\n"+"    1 штука" + "\n" +"•Кинза"+"\n"+"    1 пучок" + "\n" +"•Оливковое масло"+ "\n"+"    60 г")
        val rec=findViewById<TextView>(R.id.rec)
        rec.setText("1) Измельчаем чеснок и кинзу" +"\n"+"2) Из буханки хлеба делаем тарелку для супа"+"\n"+"3) Варим суп, наливаем в хлебную тарелку" +"\n" +"4) Добавить соль и перец по вкусу.")
        val tit=findViewById<TextView>(R.id.titlerec)
        tit.setText("Суп из хлеба")
    }





}