package com.example.quizfragmentspt2


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



/**
 * A simple [Fragment] subclass.
 * Use the [DifficultyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DifficultyFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_difficulty, container, false)
    }

    fun getDifficulty(fullName:String){
        var numberOfQuestions : Int

        var difficulty: String

        val easyButton = view?.findViewById<Button>(R.id.easy_button)

        val mediumButton = view?.findViewById<Button>(R.id.medium_button)

        val hardButton = view?.findViewById<Button>(R.id.hard_button)


        easyButton?.setOnClickListener {

            numberOfQuestions = 5
            difficulty = "easy"
            launchQuestionsActivity(numberOfQuestions,fullName, difficulty)

        }


        mediumButton?.setOnClickListener {
            numberOfQuestions = 10
            difficulty = "medium"
            launchQuestionsActivity(numberOfQuestions,fullName, difficulty)
        }

        hardButton?.setOnClickListener {
            numberOfQuestions = 20
            difficulty = "hard"
            launchQuestionsActivity(numberOfQuestions,fullName, difficulty)

        }
    }

    private fun launchQuestionsActivity(numberOfQuestions:Int,fullName:String, difficulty:String){
        val intent = Intent(context, QuestionsActivity::class.java)

        intent.putExtra("fullName",fullName)
        intent.putExtra("numberOfQuestions",numberOfQuestions)
        intent.putExtra("difficulty",difficulty)

        startActivity(intent)

    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DifficultyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}