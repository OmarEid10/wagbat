package com.example.wagbat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wagbat.databinding.ActivityCartBinding


class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        binding = ActivityCartBinding.inflate(layoutInflater) // Inflate layout using binding
        setContentView(binding.root)


        binding.CartButton.setOnClickListener {
            val intent = Intent(this, OrderConfirmActivity::class.java)
            startActivity(intent)
        }
    }
}