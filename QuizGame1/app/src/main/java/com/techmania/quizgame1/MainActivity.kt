package com.techmania.quizgame1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.techmania.quizgame1.databinding.ActivityMainBinding
import com.techmania.quizgame1.ui.theme.QuizGame1Theme


import android.content.Intent
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding=ActivityMainBinding.inflate((layoutInflater))
        val view =mainBinding.root


       setContentView(view)


            mainBinding.buttonSignOut.setOnClickListener{

                FirebaseAuth.getInstance().signOut()
                val intent=Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
    }
}

