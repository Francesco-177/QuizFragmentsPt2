package com.example.quizfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val fullName = intent.extras?.getString("fullName").toString()
        val numberOfQuestions = intent.extras?.getInt("numberOfQuestions") ?: 0

        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        val categories = listOf(
            "Legendary Drivers",
            "Historic Teams",
            "Records and Statistics",
            "Epic Races",
            "2021 F1 Season"
        )

        val adapter = QuestionsCategoryAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = categories[position]
        }.attach()


    }
}
