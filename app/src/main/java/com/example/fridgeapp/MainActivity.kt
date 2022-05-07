package com.example.fridgeapp

import android.Manifest
import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.label.ImageLabeler
import com.google.mlkit.vision.label.ImageLabeling
import com.google.mlkit.vision.label.defaults.ImageLabelerOptions
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    lateinit var ivPicture:ImageView
    lateinit var tvResult:TextView
    lateinit var btnChoosePicture:Button
    private val CAMERA_PERMISSION_CODE=123
    private val STORAGE_PERMISSION_CODE=113
    var holodilnick = "space"
    var chenapolke : ArrayList<String> = arrayListOf()
    var chechetam = "space"

    private val TAG="MyTag"

    private lateinit var cameraLauncher:ActivityResultLauncher<Intent>
    private lateinit var galleryLauncher:ActivityResultLauncher<Intent>

    lateinit var inputImage: InputImage

    lateinit var imagelabeler:ImageLabeler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivPicture=findViewById(R.id.ivPicture)
        tvResult=findViewById(R.id.tvResult)
        btnChoosePicture=findViewById(R.id.btnChoosePicture)

        imagelabeler= ImageLabeling.getClient(ImageLabelerOptions.DEFAULT_OPTIONS)

        cameraLauncher=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            object : ActivityResultCallback<ActivityResult>{
                override fun onActivityResult(result: ActivityResult?) {
                    val data=result?.data
                    try{
                        val photo=data?.extras?.get("data") as Bitmap
                        ivPicture.setImageBitmap(photo)
                        inputImage=InputImage.fromBitmap(photo,0)
                        processImage()
                    }catch (e:Exception){
                        Log.d(TAG,"onActivityResult: ${e.message}")
                    }
                }
            }
        )

        galleryLauncher=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            object : ActivityResultCallback<ActivityResult>{
                override fun onActivityResult(result: ActivityResult?) {
                    val data=result?.data
                    try{
                        inputImage= InputImage.fromFilePath(this@MainActivity, data?.data!!)
                        ivPicture.setImageURI(data?.data)
                        processImage()
                    }catch (e:Exception){

                    }
                }
            }
        )





        btnChoosePicture.setOnClickListener{

            val options= arrayOf("camera","gallery")
            val builder= AlertDialog.Builder(this@MainActivity)
            builder.setTitle("Pick a option")
            builder.setItems(options, DialogInterface.OnClickListener{
                dialog, which ->
                    if(which==0){
                        //checkPermission(Manifest.permission.CAMERA,CAMERA_PERMISSION_CODE)
                        val cameraIntent= Intent (MediaStore.ACTION_IMAGE_CAPTURE)
                        cameraLauncher.launch(cameraIntent)
                    }else{
                        //checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE,STORAGE_PERMISSION_CODE)
                        val storageIntent= Intent()
                        storageIntent.setType("image/*")
                        storageIntent.setAction(Intent.ACTION_GET_CONTENT)
                        galleryLauncher.launch(storageIntent)
                    }
            })
            builder.show()
        }

        val scan = findViewById<ImageView>(R.id.arrowback)
        scan.setOnClickListener{
            val randomIntent = Intent(this, GreatMenu::class.java)
            startActivity(randomIntent)
        }
    }

    private fun processImage(){
        imagelabeler.process(inputImage)
            .addOnSuccessListener {
                var result=""



                for (label in it) {
                    //val text = label.text
                    holodilnick = label.text.toString()
                    if ("Fruit" in holodilnick.substringBefore(',')||"Food" in holodilnick.substringBefore(',')||"Meat" in holodilnick.substringBefore(',')||"Chicken" in holodilnick.substringBefore(',')||"Vegetable" in holodilnick.substringBefore(',')||"Eggs" in holodilnick.substringBefore(',')||"Egg" in holodilnick.substringBefore(',')||"Bread" in holodilnick.substringBefore(',')||"Fish" in holodilnick.substringBefore(',')) {

                        result = result + "\n" + label.text
                        chenapolke.add(label.text)
                        //print(chenapolke)
                    }
                }
                val catSet = chenapolke.toSet()
                chechetam=catSet.toString().drop(1).dropLast(1)
                val spisok=findViewById<TextView>(R.id.spisochek)
                spisok.setText(chechetam)

                tvResult.text=result

            }.addOnFailureListener{
                Log.d(TAG, "processImage: ${it.message}")
            }
    }

    override fun onResume() {
        super.onResume()

        checkPermission(Manifest.permission.CAMERA,CAMERA_PERMISSION_CODE)
    }

    private fun checkPermission(permission:String, requestCode:Int){
        if (ContextCompat.checkSelfPermission(this@MainActivity,permission)==PackageManager.PERMISSION_DENIED) {

            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission), requestCode)
        }else{
            Toast.makeText(this@MainActivity,"Permission Granted already", Toast.LENGTH_LONG).show()

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode==CAMERA_PERMISSION_CODE){
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "Camera Permission Granted", Toast.LENGTH_LONG)
                    .show()
            }else{
                Toast.makeText(this@MainActivity,"Camera Permission Denied", Toast.LENGTH_LONG).show()
            }
        }else if(requestCode==STORAGE_PERMISSION_CODE){
            if(grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this@MainActivity, "Storage Permission Granted", Toast.LENGTH_LONG)
                    .show()
            }else{
                Toast.makeText(this@MainActivity,"Storage Permission Denied", Toast.LENGTH_LONG).show()
            }

        }
    }




}