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
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



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
    private var score: Int = 0

    private var currentCategory: String = ""



    // Define the categories
    private val categories = listOf(
        "Legendary Drivers",
        "Historic Teams",
        "Records and Statistics",
        "Epic Races",
        "2021 F1 Season"
    )

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


    fun makeQuestions(numberOfQuestions:Int, fullName:String, category: String){

        val questionList = Constants.getQuestions()

        // Create a map to store shuffled lists by category
        val questionsByCategory = mutableMapOf<String, ArrayList<Question>>()

        // Iterate through the categories
        for (category in categories) {
            // Filter the questions for the current category
            val categoryQuestions = questionList.filter { it.category == category }

            // Shuffle the questions for the current category
            val shuffledQuestions = ArrayList(categoryQuestions.shuffled())

            // Add the shuffled list to the map with the category as the key
            questionsByCategory[category] = shuffledQuestions
        }

        val legendaryDriversQuestions = questionsByCategory["Legendary Drivers"]
        val historicTeamsQuestions = questionsByCategory["Historic Teams"]
        val recordsAndStatisticsQuestions = questionsByCategory["Records and Statistics"]
        val epicRacesQuestions = questionsByCategory["Epic Races"]
        val f1SeasonQuestions = questionsByCategory["2021 F1 Season"]

        // Get the list of questions for the specified category
        val selectedCategoryQuestions = questionsByCategory[category]

        if (selectedCategoryQuestions != null) {
            mQuestionsList = ArrayList(selectedCategoryQuestions)
            currentCategory = category
            mCurrentPosition = 1 // Restablece la posición actual a la primera pregunta
            setQuestion(numberOfQuestions)
        } else {
            // Manejar el caso en que no se encuentra la categoría
            Toast.makeText(requireContext(), "Categoría no encontrada", Toast.LENGTH_LONG).show()
        }


        //questionList.shuffle()

        //mQuestionsList = recordsAndStatisticsQuestions?.let { ArrayList(it) }


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
                if (mCurrentPosition < numberOfQuestions!!) {
                    mCurrentPosition++
                    setQuestion(numberOfQuestions)
                } else{


                    val intent = Intent(context, SummaryActivity::class.java)
                    intent.putExtra("fullName",fullName)
                    intent.putExtra("numberOfQuestions",numberOfQuestions)
                    intent.putExtra("mCorrectAnswers",mCorrectAnswers)
                    intent.putExtra("mWrongAnswers",mWrongAnswers)
                    startActivity(intent)


                }

            }else{
                //logica para cuando salte de pregunta
                Toast.makeText(requireContext(), getString(R.string.select_option_validation), Toast.LENGTH_LONG).show()
            }


        }


    }

    private fun setQuestion(numberOfQuestions: Int) {

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

    fun setCurrentCategory(category: String, numberOfQuestions: Int) {

    }


    companion object {
        @JvmStatic
        fun newInstance(category: String) = QuestionsFragment().apply {
            arguments = Bundle().apply {
                putString("category", category)
            }
        }
    }

}