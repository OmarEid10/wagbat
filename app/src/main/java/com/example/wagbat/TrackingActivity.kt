package com.example.wagbat

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView

class TrackingActivity : AppCompatActivity() {
    private lateinit var countdownTimer: CountDownTimer
    private lateinit var countdownTextView: TextView
    private val COUNTDOWN_TIME_MILLIS =  10 * 1000L // 50 minutes in milliseconds

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracking)

        countdownTextView = findViewById(R.id.countDown)

        // Start the countdown timer
        startCountdown()
    }

    private fun startCountdown() {
        countdownTimer = object : CountDownTimer(COUNTDOWN_TIME_MILLIS, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                val minutes = secondsRemaining / 60
                val seconds = secondsRemaining % 60

                countdownTextView.text = "Your Order Will Arrive in \n $minutes:$seconds"

            }

            override fun onFinish() {
                // Handle timer finish
                countdownTextView.text = "Your Order Has Arrived!"
            }
        }
        countdownTimer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        countdownTimer.cancel() // Cancel the timer to avoid memory leaks
    }
}
