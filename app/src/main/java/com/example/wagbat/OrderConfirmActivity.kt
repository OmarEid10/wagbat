package com.example.wagbat

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.wagbat.ConfirmitionActivity
import com.example.wagbat.databinding.ActivityOrderConfirmBinding
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class OrderConfirmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderConfirmBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val now = LocalTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        val currentTime = now.format(formatter)

        val radioButton12PM = binding.radioButton1
        val radioButton3PM = binding.radioButton2
        val mainGate = binding.radioButton3
        val secondGate = binding.radioButton4

        radioButton12PM.isEnabled = currentTime >= "07:00:00" && currentTime < "10:00:00"
        radioButton3PM.isEnabled = currentTime >= "07:00:00" && currentTime < "11:59:00"

        mainGate.isEnabled = currentTime >= "07:00:00" && currentTime < "11:59:00"
        secondGate.isEnabled = currentTime >= "07:00:00" && currentTime < "11:59:00"

        val timeButtons = binding.timeButtons
        timeButtons.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton = findViewById<RadioButton>(checkedId)
            val selectedTime = selectedRadioButton.text.toString()
            Toast.makeText(this, selectedTime, Toast.LENGTH_SHORT).show()
        }

        val placeButtons = binding.placeButtons
        placeButtons.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton = findViewById<RadioButton>(checkedId)
            val selectedPlace = selectedRadioButton.text.toString()
            Toast.makeText(this, selectedPlace, Toast.LENGTH_SHORT).show()
        }

        binding.button2.setOnClickListener {
            // Check if both time and place options are selected
            val selectedTimeId = timeButtons.checkedRadioButtonId
            val selectedPlaceId = placeButtons.checkedRadioButtonId
            if (selectedTimeId == -1 || selectedPlaceId == -1) {
                Toast.makeText(this, "Please select both time and place", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ConfirmitionActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
