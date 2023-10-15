package com.example.quizfragmentspt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val fullName = intent.extras?.getString("fullName").toString()
        val numberOfQuestions = intent.extras?.getInt("numberOfQuestions")!!.toInt()
        val correctAnswers = intent.extras?.getInt("mCorrectAnswers")!!.toInt()
        val wrongAnswers = intent.extras?.getInt("mWrongAnswers")!!.toInt()
        val remainingQuestions = intent.extras?.getInt("remainingQuestions")!!.toInt()
        val skippedQuestions = intent.extras?.getInt("skippedQuestions")!!.toInt()
        val score = intent.extras?.getInt("score")!!.toInt()


        val summaryFragment = supportFragmentManager .findFragmentById(R.id.summaryFragment) as SummaryFragment
        summaryFragment.showResults(fullName, numberOfQuestions, correctAnswers, wrongAnswers,remainingQuestions,skippedQuestions,score)
    }
}