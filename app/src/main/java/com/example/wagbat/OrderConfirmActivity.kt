package com.example.wagbat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OrderConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_confirm)


        val secondButton = findViewById<Button>(R.id.button2)
        secondButton.setOnClickListener {
            val Button = Intent(this,ConfirmitionActivity::class.java)
            startActivity(Button)
        }
    }


}