package com.example.quizfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DifficultyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_difficulty)

        val fullName = intent.extras?.getString("fullName").toString()
        val difficultyFragment = supportFragmentManager .findFragmentById(R.id.difficultyFragment) as DifficultyFragment
        difficultyFragment.getDifficulty(fullName)

    }
}