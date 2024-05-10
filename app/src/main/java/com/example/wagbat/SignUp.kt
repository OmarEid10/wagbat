package com.example.waagbaat

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.waagbaat.databinding.ActivityLoginBinding
import com.example.waagbaat.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    private lateinit var binding2: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding2 = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding2.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding2.textView.setOnClickListener {
            var intent = Intent(this,login::class.java)
            startActivity(intent)
        }

        binding2.button.setOnClickListener {
            var email = binding2.emailEt.text.toString()
            var password = binding2.passET.text.toString()
            var confirmPass = binding2.confirmPassEt.text.toString()

            if(email.isNotEmpty()&&password.isNotEmpty()&&confirmPass.isNotEmpty()){

                if(password == confirmPass){
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                        if(it.isSuccessful){
                            var intent = Intent(this,login::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this,it.exception.toString(),Toast.LENGTH_LONG).show()

                        }
                    }
                }else{
                    Toast.makeText(this,"Password is not the same",Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(this,"Empty Filed Not Allowed!",Toast.LENGTH_LONG).show()

            }

        }

    }
}