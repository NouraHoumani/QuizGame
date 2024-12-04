package com.techmania.quizgame1

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.techmania.quizgame1.databinding.ActivityLoginBinding
import android.content.Intent
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var loginBinding: ActivityLoginBinding
    val auth=FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginBinding=ActivityLoginBinding.inflate(layoutInflater)
        val view=loginBinding.root

        enableEdgeToEdge()
        setContentView(view)


        loginBinding.buttonSignin.setOnClickListener{

            val userEmail=loginBinding.editTextLoginEmail.text.toString()
            val userPassword=loginBinding.editTextLoginPassword.text.toString()
            signInUser(userEmail,userPassword)



        }

        loginBinding.textViewSignup.setOnClickListener{

            val intent=Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
        loginBinding.textViewForgotPassword.setOnClickListener{

            val intent=Intent(this,ForgotPasswordActivity::class.java)
            startActivity(intent)

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun signInUser(userEmail : String , userPassword : String) {

        auth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener { task ->

            if(task.isSuccessful){

                Toast.makeText(applicationContext,"Welcome to quiz game!",Toast.LENGTH_SHORT).show()
                val intent=Intent(this@LoginActivity,MainActivity::class.java)
                startActivity(intent)
                finish()

            } else {

                Toast.makeText(applicationContext,task.exception?.localizedMessage,Toast.LENGTH_SHORT).show()

            }
        }

    }

    override fun onStart() {
        super.onStart()

        val user =auth.currentUser
        if(user!=null){
            Toast.makeText(applicationContext,"Welcome to quiz game!",Toast.LENGTH_SHORT).show()
            val intent=Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}