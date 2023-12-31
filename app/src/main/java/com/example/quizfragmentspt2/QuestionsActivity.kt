package com.example.quizfragmentspt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuestionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        // Obteniendo datos de la actividad anterior
        val fullName = intent.extras?.getString("fullName", "") ?: ""
        val numberOfQuestions = intent.extras?.getInt("numberOfQuestions", 0) ?: 0
        val difficulty = intent.extras?.getString("difficulty", "") ?: ""

        val questionsFragment = supportFragmentManager .findFragmentById(R.id.questionsFragment) as QuestionsFragment
        questionsFragment.logicQuestion(numberOfQuestions, fullName, difficulty)



    }
}
