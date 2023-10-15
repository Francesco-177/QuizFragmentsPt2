package com.example.quizfragmentspt2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SummaryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val finishButton: Button?
        get() = view?.findViewById(R.id.finish_button)

    private val resultsHeaderTV: TextView?
        get() = view?.findViewById(R.id.results_header)

    private val totalQuestionsTV: TextView?
        get() = view?.findViewById(R.id.total_questions)

    private val correctAnswersTV: TextView?
        get() = view?.findViewById(R.id.correct_answers)

    private val wrongAnswersTV: TextView?
        get() = view?.findViewById(R.id.wrong_answers)
    private val skippedQuestionsTV: TextView?
        get() = view?.findViewById(R.id.skipped_questions)

    private val remainingQuestionsTV: TextView?
        get() = view?.findViewById(R.id.remaining_questions)

    private val scoreTV: TextView?
        get() = view?.findViewById(R.id.score_header)


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
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    fun showResults(fullName:String, numberOfQuestions:Int, correctAnswers:Int, wrongAnswers:Int, remainingQuestions:Int,skippedQuestions:Int,score:Int){

        resultsHeaderTV?.text = getString(R.string.results_text,fullName)

        totalQuestionsTV?.text= getString(R.string.total_questions_text, numberOfQuestions.toString())

        correctAnswersTV?.text= getString(R.string.correct_answers_text, correctAnswers.toString())

        wrongAnswersTV?.text=  getString(R.string.wrong_answers_text, wrongAnswers.toString())

        remainingQuestionsTV?.text= getString(R.string.remaining_questions_text, remainingQuestions.toString())

        skippedQuestionsTV?.text= getString(R.string.skipped_questions_text, skippedQuestions.toString())

        scoreTV?.text= getString(R.string.score_text, score.toString())


        finishButton?.setOnClickListener{

            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
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