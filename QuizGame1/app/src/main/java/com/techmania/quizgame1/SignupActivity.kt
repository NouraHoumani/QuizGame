package com.techmania.quizgame1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.techmania.quizgame1.databinding.ActivitySignupBinding
import com.google.firebase.FirebaseApp

import kotlin.math.sign

class SignupActivity : AppCompatActivity() {

    lateinit var signupBinding: ActivitySignupBinding

    val auth : FirebaseAuth=FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)


        signupBinding=ActivitySignupBinding.inflate(layoutInflater)

        val view=signupBinding.root
        enableEdgeToEdge()
        setContentView(view)

        signupBinding.buttonSignup.setOnClickListener{
            val email= signupBinding.editTextSignupEmail.text.toString()
            val password=signupBinding.editTextSignupPassword.text.toString()


            signupWithFirebase(email,password)
        }

    }

    fun signupWithFirebase(email : String, password : String){

        signupBinding.progressBarSignup.visibility= View.VISIBLE
        signupBinding.buttonSignup.isClickable=false


        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
            if(task.isSuccessful){

                Toast.makeText(applicationContext,"Your Account has been created!",Toast.LENGTH_SHORT).show()
                finish()
                signupBinding.progressBarSignup.visibility=View.INVISIBLE
                signupBinding.buttonSignup.isClickable=true

            } else {

                Toast.makeText(applicationContext, task.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
            }

        }
    }

}

