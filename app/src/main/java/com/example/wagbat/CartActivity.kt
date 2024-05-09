package com.example.wagbat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val firstButton = findViewById<Button>(R.id.button1)
        firstButton.setOnClickListener {
            val Intent = Intent(this,OrderConfirmActivity::class.java)
            startActivity(Intent)
        }
    }
}