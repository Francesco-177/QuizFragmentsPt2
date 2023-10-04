package com.example.quizfragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
    private var mQuestionsList = mutableListOf<Question>()
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mWrongAnswers: Int = 0
    private var score: Int = 0

    private lateinit var selectedCategory: String




    private var numberOfQuestions:Int = 0
    private var fullName:String = ""


    // Define the categories
    private val categories = listOf(
        "Legendary Drivers",
        "Historic Teams",
        "Records and Statistics",
        "Epic Races",
        "2021 F1 Season"
    )

    private lateinit var category: String

    //val currentCategory = categories[adapterPosition]



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
        val view = inflater.inflate(R.layout.fragment_questions, container, false)
        selectedCategory = requireArguments().getString("category", "")
        // Obtener la categoría, el nombre completo y el número de preguntas desde los argumentos
        category = requireArguments().getString("category", "")
        fullName = requireArguments().getString("fullName", "")
        numberOfQuestions = requireArguments().getInt("numberOfQuestions", 0)

        makeList()

        answerQuestion(numberOfQuestions, fullName)

        return view
    }


    fun answerQuestion(numberOfQuestions:Int, fullName:String){
        Log.d("QuestionsFragment", "answerQuestions function started") // Agregar registro de fin de la función


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
                val question = mQuestionsList[mCurrentPosition - 1]

                // This is to check if the answer is wrong
                if (question.correctAnswer != mSelectedOptionPosition) {
                    mWrongAnswers++
                } else {
                    mCorrectAnswers++
                }

                mSelectedOptionPosition = 0 // Restablece la selección de opción a 0 después de procesar la respuesta.

                // Incrementa mCurrentPosition solo si no has llegado al final de las preguntas
                if (mCurrentPosition < numberOfQuestions!!) {
                    mCurrentPosition++

                    // Llamar a la función para obtener la pregunta actual
                    makeList()


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

        Log.d("QuestionsFragment", "answerQuestions function completed") // Agregar registro de fin de la función


    }
    fun makeList() {
        optionOneButton?.setBackgroundResource(R.drawable.default_button_design)
        optionTwoButton?.setBackgroundResource(R.drawable.default_button_design)
        optionThreeButton?.setBackgroundResource(R.drawable.default_button_design)

        val questionList = Constants.getQuestions()

        // Obtén la lista de preguntas para la categoría actual (selectedCategory)
        val selectedCategoryQuestions = questionList.filter { it.category == selectedCategory }

        // Shuffle the questions for the current category
        val shuffledQuestions = ArrayList(selectedCategoryQuestions.shuffled())

        // Restablece la posición actual a la primera pregunta
        mCurrentPosition = 1

        // Obtén la pregunta actual
        val currentQuestion = shuffledQuestions[mCurrentPosition - 1]

        // Configura el texto de la pregunta en el TextView
        questionsHeader?.text = currentQuestion.question

        // Configura el texto de las opciones en los botones
        optionOneButton?.text = currentQuestion.optionOne
        optionTwoButton?.text = currentQuestion.optionTwo
        optionThreeButton?.text = currentQuestion.optionThree

        if (mCurrentPosition == numberOfQuestions) {
            submitButton?.text = getString(R.string.finish_quiz)
        } else {
            submitButton?.text = getString(R.string.next_question)
        }
    }




    companion object {
        fun newInstance(category: String, fullName: String, numberOfQuestions: Int): QuestionsFragment {
            val fragment = QuestionsFragment()
            val args = Bundle()
            args.putString("category", category)
            args.putString("fullName", fullName)
            args.putInt("numberOfQuestions", numberOfQuestions)
            fragment.arguments = args
            return fragment
        }
    }

}
