package com.example.quizfragmentspt2

data class Question(
    val id: Int,
    val question: String,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val correctAnswer: Int,
    val category: String
)