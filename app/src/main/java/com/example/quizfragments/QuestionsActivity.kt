package com.example.quizfragments;

import androidx.appcompat.app.AppCompatActivity


import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
class QuestionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        val fullName = intent.extras?.getString("fullName").toString()
        val numberOfQuestions = intent.extras?.getInt("numberOfQuestions") ?: 0

        // Crear el adaptador y configurarlo en el ViewPager2
        val adapter = QuestionsCategoryAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter


        // Recorre las categorías y crea fragmentos para cada una
        for (category in categories) {
            val fragment = QuestionsFragment.newInstance(category, fullName, numberOfQuestions) // Pasa la categoría como argumento
            adapter.addFragment(fragment, category)
        }
        // Luego, adjuntar TabLayoutMediator después de configurar el adaptador
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getTitle(position)
        }.attach()


        // Por ejemplo, para obtener el fragmento en la posición 0 (primer fragmento):
        val firstFragment = adapter.getFragment(0) as QuestionsFragment
        val secondFragment = adapter.getFragment(1) as QuestionsFragment
        val thirdFragment = adapter.getFragment(2) as QuestionsFragment
        val fourthFragment = adapter.getFragment(3) as QuestionsFragment
        val fifthFragment = adapter.getFragment(4) as QuestionsFragment



    }
}
