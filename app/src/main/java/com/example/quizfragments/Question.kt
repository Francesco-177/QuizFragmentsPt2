package com.example.quizfragments

import android.os.Parcel
import android.os.Parcelable

data class Question(
    val id: Int,
    val question: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val correctAnswer: Int,
    val category: String
)