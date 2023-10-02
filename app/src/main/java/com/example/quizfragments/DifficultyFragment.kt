package com.example.quizfragments


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

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
        var numberOfQuestions : Int = 0

        val easyButton = view?.findViewById<Button>(R.id.easy_button)

        val mediumButton = view?.findViewById<Button>(R.id.medium_button)

        val hardButton = view?.findViewById<Button>(R.id.hard_button)


        easyButton?.setOnClickListener {

            numberOfQuestions = 5
            launchQuestionsActivity(numberOfQuestions,fullName)

        }


        mediumButton?.setOnClickListener {
            numberOfQuestions = 10
            launchQuestionsActivity(numberOfQuestions,fullName)
        }

        hardButton?.setOnClickListener {
            numberOfQuestions = 20
            launchQuestionsActivity(numberOfQuestions,fullName)

        }
    }

    private fun launchQuestionsActivity(numberOfQuestions:Int,fullName:String ){
        val intent = Intent(context, QuestionsActivity::class.java)

        intent.putExtra("fullName",fullName)
        intent.putExtra("numberOfQuestions",numberOfQuestions)

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