package com.techmania.quizgame1

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.techmania.quizgame1.databinding.ActivityLoginBinding
import android.content.Intent

class LoginActivity : AppCompatActivity() {

    lateinit var loginBinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginBinding=ActivityLoginBinding.inflate(layoutInflater)
        val view=loginBinding.root

        enableEdgeToEdge()
        setContentView(view)


        loginBinding.buttonSignin.setOnClickListener{

        }

        loginBinding.textViewSignup.setOnClickListener{

            val intent=Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
        loginBinding.textViewForgotPassword.setOnClickListener{

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}