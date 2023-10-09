package com.example.quizfragmentspt2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class QuestionsFragment : Fragment() {

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

    private val scoreHeader: TextView?
        get() = view?.findViewById(R.id.score_header)

    private val finishedCategoryHeader: TextView?
        get() = view?.findViewById(R.id.finished_category_header)

    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mWrongAnswers: Int = 0
    private var score: Int = 0

    private var numberOfQuestions:Int? = 0
    private var fullName:String? = ""

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2


    private var legendaryDriversQuestions: List<Question>? = null
    private var historicTeamsQuestions: List<Question>? = null
    private var recordsAndStatisticsQuestions: List<Question>? = null
    private var epicRacesQuestions: List<Question>? = null
    private var f1SeasonQuestions: List<Question>? = null

    private var currentCategory: String = "Legendary Drivers"
    private val completedCategories = mutableSetOf<String>() // Para rastrear las categorías completadas
    private var allTabsCompleted = false





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_questions, container, false)

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

        legendaryDriversQuestions = questionsByCategory["Legendary Drivers"]
        historicTeamsQuestions = questionsByCategory["Historic Teams"]
        recordsAndStatisticsQuestions = questionsByCategory["Records and Statistics"]
        epicRacesQuestions = questionsByCategory["Epic Races"]
        f1SeasonQuestions = questionsByCategory["2021 F1 Season"]

        fullName = arguments?.getString("fullName")
        numberOfQuestions = arguments?.getInt("numberOfQuestions")

        // Inicializa las vistas
        tabLayout = view.findViewById(R.id.tab_layout)
        viewPager = view.findViewById(R.id.view_pager)

        // Crea un adaptador para el ViewPager2
        val adapter = QuestionsCategoryAdapter(childFragmentManager, lifecycle)

        // Configura el ViewPager2 con el adaptador
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        val tab1 = tabLayout.newTab()
        tab1.text = getString(R.string.legendary_drivers)

        val tab2 = tabLayout.newTab()
        tab2.text = getString(R.string.historic_teams)

        val tab3 = tabLayout.newTab()
        tab3.text = getString(R.string.records_and_statistics)

        val tab4 = tabLayout.newTab()
        tab4.text = getString(R.string.epic_races)

        val tab5 = tabLayout.newTab()
        tab5.text = getString(R.string.f1_season)

        // Agrega las pestañas al TabLayout
        tabLayout.addTab(tab1)
        tabLayout.addTab(tab2)
        tabLayout.addTab(tab3)
        tabLayout.addTab(tab4)
        tabLayout.addTab(tab5)


        // Agrega un listener al TabLayout para detectar cambios de pestaña/tab
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                // Obtén la posición de la pestaña/tab seleccionada
                val position = tab?.position ?: 0

                // Actualiza la categoría actual según la posición de la pestaña/tab
                currentCategory = when (position) {
                    0 -> "Legendary Drivers"
                    1 -> "Historic Teams"
                    2 -> "Records and Statistics"
                    3 -> "Epic Races"
                    4 -> "2021 F1 Season"
                    else -> "Legendary Drivers" // Valor predeterminado en caso de error
                }
                // Carga la lista de preguntas correspondiente
                loadQuestionsForCategory(currentCategory)

                // Verifica si numberOfQuestions es igual a mCurrentPosition en la pestaña/tab actual
                val isTabCompleted = numberOfQuestions == mCurrentPosition

                // Si todas las pestañas están completadas, establece allTabsCompleted en true
                allTabsCompleted = allTabsCompleted || isTabCompleted

                if (isTabCompleted) {
                    optionOneButton?.visibility = View.GONE
                    optionTwoButton?.visibility = View.GONE
                    optionThreeButton?.visibility = View.GONE
                    questionsHeader?.visibility = View.GONE
                    submitButton?.visibility = View.GONE

                    finishedCategoryHeader?.visibility = View.VISIBLE
                }

                // Si todas las pestañas están completadas, lanza la SummaryActivity
                if (allTabsCompleted) {
                    val intent = Intent(context, SummaryActivity::class.java)
                    intent.putExtra("fullName", fullName)
                    intent.putExtra("numberOfQuestions", numberOfQuestions)
                    intent.putExtra("mCorrectAnswers", mCorrectAnswers)
                    intent.putExtra("mWrongAnswers", mWrongAnswers)
                    startActivity(intent)
                }





            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        // Inicialmente, carga las preguntas para la categoría predeterminada (Legendary Drivers)
        loadQuestionsForCategory(currentCategory)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }



    fun logicQuestion(numberOfQuestions:Int, fullName:String){
        Log.d("QuestionsFragment", "logicQuestion function started") // Agregar registro de fin de la función

        Log.d("QuestionsFragment", "mQuestionsList: $mQuestionsList")

        makeQuestion()

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
                if (question?.correctAnswer != mSelectedOptionPosition) {
                    mWrongAnswers++

                } else {
                    mCorrectAnswers++

                }

                mSelectedOptionPosition = 0 // Restablece la selección de opción a 0 después de procesar la respuesta.

                countScore(numberOfQuestions)

                // Verifica si es matemáticamente imposible ganar
               // if (isImpossibleToWin(numberOfQuestions)) {
               //     Toast.makeText(requireContext(), "¡Perdiste! Es matemáticamente imposible ganar.", Toast.LENGTH_LONG).show()
               // }


                // Incrementa mCurrentPosition solo si no has llegado al final de las preguntas
                if (mCurrentPosition < numberOfQuestions) {
                    mCurrentPosition++

                    // Llamar a la función para obtener la pregunta actual
                    makeQuestion()

                }

            }else{
                //logica para cuando salte de pregunta
                Toast.makeText(requireContext(), getString(R.string.select_option_validation), Toast.LENGTH_LONG).show()
            }

        }

        Log.d("QuestionsFragment", "logicQuestion function completed") // Agregar registro de fin de la función

    }

    private fun makeQuestion() {

        optionOneButton?.setBackgroundResource(R.drawable.default_button_design)
        optionTwoButton?.setBackgroundResource(R.drawable.default_button_design)
        optionThreeButton?.setBackgroundResource(R.drawable.default_button_design)

        // Obtén la pregunta actual
        val currentQuestion = mQuestionsList?.get(mCurrentPosition - 1)

        // Configura el texto de la pregunta en el TextView
        questionsHeader?.text = currentQuestion?.question

        // Configura el texto de las opciones en los botones
        optionOneButton?.text = currentQuestion?.optionOne
        optionTwoButton?.text = currentQuestion?.optionTwo
        optionThreeButton?.text = currentQuestion?.optionThree

        if (mCurrentPosition - 1 == numberOfQuestions) {
            submitButton?.text = getString(R.string.finish_category)
        } else {
            submitButton?.text = getString(R.string.next_question)
        }
    }

    private fun loadQuestionsForCategory(category: String) {
        mQuestionsList = when (category) {
            "Legendary Drivers" -> legendaryDriversQuestions as ArrayList<Question>?
            "Historic Teams" -> historicTeamsQuestions as ArrayList<Question>?
            "Records and Statistics" -> recordsAndStatisticsQuestions as ArrayList<Question>?
            "Epic Races" -> epicRacesQuestions as ArrayList<Question>?
            "2021 F1 Season" -> f1SeasonQuestions as ArrayList<Question>?
            else -> null // Manejo de error si la categoría no coincide
        }

        makeQuestion()
        numberOfQuestions?.let { fullName?.let { it1 -> logicQuestion(it, it1) } }

    }

    private fun countScore(numberOfQuestions:Int) {
        score = when (numberOfQuestions) {
            5 -> (mCorrectAnswers * 100) - (mWrongAnswers * 100) // 100 puntos por respuesta correcta y 100 puntos restados por respuesta incorrecta
            10 -> (mCorrectAnswers * 250) - (mWrongAnswers * 250) // 250 puntos por respuesta correcta y 250 puntos restados por respuesta incorrecta
            20 -> (mCorrectAnswers * 500) - (mWrongAnswers * 500) // 500 puntos por respuesta correcta y 500 puntos restados por respuesta incorrecta
            else -> 0 // Valor predeterminado si el número de preguntas no coincide con ninguno de los casos
        }

        scoreHeader?.text =  getString(R.string.score_text,score.toString())
    }

    // Verifica si es matemáticamente imposible ganar

    private fun isImpossibleToWin(numberOfQuestions: Int): Boolean {
        val remainingQuestions = numberOfQuestions - (mWrongAnswers + mCorrectAnswers)

        val maxPossibleScore = score + (remainingQuestions * getPossibleScorePerQuestion(numberOfQuestions))
        val minRequiredScore = 1000
        return maxPossibleScore < minRequiredScore
    }

    // Obtiene el puntaje posible por pregunta en función de la cantidad de preguntas
    private fun getPossibleScorePerQuestion(totalQuestions: Int): Int {
        return when (totalQuestions) {
            5 -> 100 // Puntaje por pregunta con 5 preguntas
            10 -> 250 // Puntaje por pregunta con 10 preguntas
            20 -> 500 // Puntaje por pregunta con 20 preguntas
            else -> 0 // Valor predeterminado en caso de que el número de preguntas no coincida con ninguno de los casos
        }
    }

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: String): QuestionsFragment {
            val fragment = QuestionsFragment()
            val args = Bundle()
            args.putString(ARG_CATEGORY, category)
            fragment.arguments = args
            return fragment
        }
    }






}