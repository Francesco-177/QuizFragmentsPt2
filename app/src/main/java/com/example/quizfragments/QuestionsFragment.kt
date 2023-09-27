package com.example.quizfragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
 * Use the [QuestionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val optionOneButton: Button?
        get() = view?.findViewById(R.id.option_one_button)

    private val optionTwoButton: Button?
        get() = view?.findViewById(R.id.option_two_button)

    private val optionThreeButton: Button?
        get() = view?.findViewById(R.id.option_three_button)

    private val submitButton: Button?
        get() = view?.findViewById(R.id.submit_button)

    private val questionsHeader: TextView?
        get() = view?.findViewById(R.id.questions_header)



    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mWrongAnswers: Int = 0

    private val bundle = requireArguments()
    private val numberOfQuestions = bundle.getInt("totalQuestions", 0)


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
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val questionList = Constants.getQuestions()

        questionList.shuffle()

        mQuestionsList = questionList

        setQuestion()


        optionOneButton?.setOnClickListener{

            optionOneButton?.setBackgroundResource(R.drawable.selected_button_design)
            optionTwoButton?.setBackgroundResource(R.drawable.default_button_design)
            optionThreeButton?.setBackgroundResource(R.drawable.default_button_design)
            mSelectedOptionPosition = 1
        }

        optionTwoButton?.setOnClickListener{

            optionOneButton?.setBackgroundResource(R.drawable.default_button_design)
            optionTwoButton?.setBackgroundResource(R.drawable.selected_button_design)
            optionThreeButton?.setBackgroundResource(R.drawable.default_button_design)
            mSelectedOptionPosition = 2
        }

        optionThreeButton?.setOnClickListener{

            optionOneButton?.setBackgroundResource(R.drawable.default_button_design)
            optionTwoButton?.setBackgroundResource(R.drawable.default_button_design)
            optionThreeButton?.setBackgroundResource(R.drawable.selected_button_design)
            mSelectedOptionPosition = 3
        }

        submitButton?.setOnClickListener{
            // Verificar si una opción se ha seleccionado antes de procesar la respuesta
            if (mSelectedOptionPosition != 0) {
                val question = mQuestionsList?.get(mCurrentPosition - 1)

                // This is to check if the answer is wrong
                if (question!!.correctAnswer != mSelectedOptionPosition) {
                    mWrongAnswers++
                } else {
                    mCorrectAnswers++
                }

                mSelectedOptionPosition = 0 // Restablece la selección de opción a 0 después de procesar la respuesta.

                // Incrementa mCurrentPosition solo si no has llegado al final de las preguntas
                if (mCurrentPosition < numberOfQuestions) {
                    mCurrentPosition++
                    setQuestion()
                } else{

                    // Crear un Bundle y agregar datos
                    val bundle = Bundle()
                    bundle.putInt("correctAnswers", mCorrectAnswers)
                    bundle.putInt("wrongAnswers", mWrongAnswers)
                    bundle.putInt("totalQuestions", numberOfQuestions)

                    // Crear un Intent
                    val intent = Intent(requireContext(), SummaryFragment::class.java)

                    // Colocar el Bundle en el Intent
                    intent.putExtras(bundle)

                    val summaryFragment = SummaryFragment()
                    val fragmentManager = requireActivity().supportFragmentManager
                    val transaction = fragmentManager.beginTransaction()
                    transaction.replace(R.id.fragment_container, summaryFragment)
                    transaction.commit()

                }

            }else{
                Toast.makeText(requireContext(), getString(R.string.select_option_validation), Toast.LENGTH_LONG).show()
            }


        }



    }

    private fun setQuestion() {

        optionOneButton?.setBackgroundResource(R.drawable.default_button_design)
        optionTwoButton?.setBackgroundResource(R.drawable.default_button_design)
        optionThreeButton?.setBackgroundResource(R.drawable.default_button_design)

        val question = mQuestionsList!!.get(mCurrentPosition - 1) // Getting the question from the list with the help of current position.

        if (mCurrentPosition == numberOfQuestions) {
            submitButton?.text = getString(R.string.finish_quiz)
        } else {
            submitButton?.text = getString(R.string.next_question)
        }

        questionsHeader?.text= question.question
        optionOneButton?.text = question.optionOne
        optionTwoButton?.text = question.optionTwo
        optionThreeButton?.text = question.optionThree
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