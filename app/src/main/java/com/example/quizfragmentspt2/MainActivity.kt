package com.example.quizfragmentspt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginFragment = supportFragmentManager .findFragmentById(R.id.loginFragment) as LoginFragment
        loginFragment.getPersonalDetails()
    }
}