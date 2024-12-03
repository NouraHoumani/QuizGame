package com.techmania.quizgame1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.techmania.quizgame1.databinding.ActivityForgotPasswordBinding
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    lateinit var forgotBinding : ActivityForgotPasswordBinding

    val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        forgotBinding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        val view = forgotBinding.root
        setContentView(view)

        forgotBinding.buttonReset.setOnClickListener {

            val userEmail = forgotBinding.editTextForgotEmail.text.toString()

            auth.sendPasswordResetEmail(userEmail).addOnCompleteListener { task ->

                if (task.isSuccessful){

                    Toast.makeText(applicationContext,"We sent a password reset mail to your email address",Toast.LENGTH_SHORT).show()
                    finish()

                }else{

                    Toast.makeText(applicationContext,task.exception?.localizedMessage,Toast.LENGTH_SHORT).show()

                }

            }

        }

    }
}