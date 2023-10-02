package com.example.quizfragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

val TAB_GENRES_SCROLLABLE = listOf(
    R.string.legendary_drivers,
    R.string.historic_teams,
    R.string.records_and_statistics,
    R.string.epic_races,
    R.string.f1_season
)


class QuestionsCategoryAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return TAB_GENRES_SCROLLABLE.size
    }

    override fun createFragment(position: Int): Fragment {
        return QuestionsFragment()
    }
}