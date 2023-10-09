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

        /*

        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        val adapter = QuestionsCategoryAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_GENRES_SCROLLABLE[position])
        }.attach()


         */

        val summaryFragment = supportFragmentManager .findFragmentById(R.id.summaryFragment) as SummaryFragment
        summaryFragment.showResults(fullName, numberOfQuestions, correctAnswers, wrongAnswers)
    }
}