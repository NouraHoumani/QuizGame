package com.techmania.quizgame1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.techmania.quizgame1.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    lateinit var quizBinding: ActivityQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        quizBinding = ActivityQuizBinding.inflate(layoutInflater)
        val view = quizBinding.root
        setContentView(view)

        quizBinding.buttonNext.setOnClickListener {
            // Add your logic for the Next button click here
        }

        quizBinding.buttonFinish.setOnClickListener {
            // Add your logic for the Finish button click here
        }

        quizBinding.textViewA.setOnClickListener() {
            // Add your logic for next view click here
        }
        quizBinding.textViewB.setOnClickListener() {
            // Add your logic for next view click here
        }
        quizBinding.textViewC.setOnClickListener() {
            // Add your logic for next view click here
        }
        quizBinding.textViewD.setOnClickListener() {
            // Add your logic for next view click here
        }
    }
}
