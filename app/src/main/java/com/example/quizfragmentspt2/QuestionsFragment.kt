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

    //private var currentIndexForCategory: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mWrongAnswers: Int = 0
    private var score: Int = 0

    private var numberOfQuestions:Int? = 0
    private var totalNumberOfQuestions:Int? = 0
    private var fullName:String? = ""

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2


    private var legendaryDriversQuestions: List<Question>? = null
    private var historicTeamsQuestions: List<Question>? = null
    private var recordsAndStatisticsQuestions: List<Question>? = null
    private var epicRacesQuestions: List<Question>? = null
    private var f1SeasonQuestions: List<Question>? = null

    private var currentCategory: String = "Legendary Drivers"
    private val completedCategories = mutableSetOf<String>()

    private val categoryIndices = mutableMapOf<String, Int>()

    private var remainingQuestions:Int = 0

    private var currentIndexForCategory: Int = 0


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


                // Actualiza el índice para la categoría actual
                currentIndexForCategory = categoryIndices.getOrDefault(currentCategory, 1)

                // Carga la lista de preguntas correspondiente
                loadQuestionsForCategory(currentCategory)


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


    fun logicQuestion(numberOfQuestions:Int, fullName:String){

        Log.d("QuestionsFragment", "logicQuestion function started") // Agregar registro de fin de la función

        scoreHeader?.text =  getString(R.string.score_text,score.toString())

        currentIndexForCategory = categoryIndices[currentCategory] ?: 1

        categoryIndices[currentCategory] = currentIndexForCategory

        Log.d("QuestionsFragment", "mQuestionsList: $mQuestionsList")

        totalNumberOfQuestions = numberOfQuestions.times(categories.size)
        Log.d("QuestionsFragment", "totalNumberOfQuestions: $totalNumberOfQuestions")
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
                val question = mQuestionsList?.get(currentIndexForCategory - 1)

                // This is to check if the answer is wrong
                if (question?.correctAnswer != mSelectedOptionPosition) {
                    mWrongAnswers++

                } else {
                    mCorrectAnswers++

                }

                mSelectedOptionPosition = 0 // Restablece la selección de opción a 0 después de procesar la respuesta.

                countScore(numberOfQuestions)
                remainingQuestions = totalNumberOfQuestions!! - (mWrongAnswers + mCorrectAnswers)

                // Verifica si es matemáticamente imposible ganar
                if (isImpossibleToWin(score, totalNumberOfQuestions!!,remainingQuestions)) {
                    Toast.makeText(requireContext(), "¡Es matemáticamente imposible ganar!", Toast.LENGTH_LONG).show()
                }


                if ((currentIndexForCategory) % numberOfQuestions == 0 && currentIndexForCategory != 1 && !completedCategories.contains(currentCategory)) {

                    completeCategory(currentCategory)

                }
                if(currentIndexForCategory < totalNumberOfQuestions!!){

                    categoryIndices[currentCategory] = currentIndexForCategory + 1
                    currentIndexForCategory = categoryIndices[currentCategory]!!

                    Log.d("QuestionsFragment", "currentIndexForCategory: $currentIndexForCategory")

                    loadQuestionsForCategory(currentCategory)


                }
                if (completedCategories.size == categories.size) {
                    // Todas las categorías han sido completadas, inicia la actividad de resumen
                    val intent = Intent(context, SummaryActivity::class.java)
                    intent.putExtra("fullName", fullName)
                    intent.putExtra("numberOfQuestions", totalNumberOfQuestions)
                    intent.putExtra("mCorrectAnswers", mCorrectAnswers)
                    intent.putExtra("mWrongAnswers", mWrongAnswers)
                    intent.putExtra("score", score)
                    startActivity(intent)
                }
            }


        }

        Log.d("QuestionsFragment", "logicQuestion function completed") // Agregar registro de fin de la función

    }

    private fun makeQuestion() {

        optionOneButton?.setBackgroundResource(R.drawable.default_button_design)
        optionTwoButton?.setBackgroundResource(R.drawable.default_button_design)
        optionThreeButton?.setBackgroundResource(R.drawable.default_button_design)
        //Log.d("QuestionsFragment", "currentIndexForCategory: $currentIndexForCategory")

        val currentQuestion = mQuestionsList?.get(currentIndexForCategory)

        // Configura el texto de la pregunta en el TextView
        questionsHeader?.text = currentQuestion?.question

        // Configura el texto de las opciones en los botones
        optionOneButton?.text = currentQuestion?.optionOne
        optionTwoButton?.text = currentQuestion?.optionTwo
        optionThreeButton?.text = currentQuestion?.optionThree

        if (currentIndexForCategory  == numberOfQuestions) {
            submitButton?.text = getString(R.string.finish_category)
        } else {
            submitButton?.text = getString(R.string.next_question)
        }

    }

    private fun loadQuestionsForCategory(category: String) {
        // Establece la categoría activa en la nueva categoría
        currentCategory = category

        // Obtén el índice actual para esta categoría
        currentIndexForCategory = categoryIndices.getOrDefault(category, 1)

        // Restablece la lista de preguntas para la nueva categoría
        mQuestionsList = when (category) {
            "Legendary Drivers" -> legendaryDriversQuestions as ArrayList<Question>?
            "Historic Teams" -> historicTeamsQuestions as ArrayList<Question>?
            "Records and Statistics" -> recordsAndStatisticsQuestions as ArrayList<Question>?
            "Epic Races" -> epicRacesQuestions as ArrayList<Question>?
            "2021 F1 Season" -> f1SeasonQuestions as ArrayList<Question>?
            else -> null // Manejo de error si la categoría no coincide
        }

        // Verifica si se ha completado la categoría actual y muestra el mensaje correspondiente
        if (completedCategories.contains(category)) {

            optionOneButton?.visibility = View.GONE
            optionTwoButton?.visibility = View.GONE
            optionThreeButton?.visibility = View.GONE
            questionsHeader?.visibility = View.GONE
            submitButton?.visibility = View.GONE
            finishedCategoryHeader?.visibility = View.VISIBLE

        } else {

            optionOneButton?.visibility = View.VISIBLE
            optionTwoButton?.visibility = View.VISIBLE
            optionThreeButton?.visibility = View.VISIBLE
            questionsHeader?.visibility = View.VISIBLE
            submitButton?.visibility = View.VISIBLE
            finishedCategoryHeader?.visibility = View.GONE

        }

        makeQuestion()
        numberOfQuestions?.let { fullName?.let { it1 -> logicQuestion(it, it1) } }
    }

    private fun completeCategory(category: String) {
        // Agrega la categoría completada a la lista de categorías completadas
        completedCategories.add(category)
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

    // Obtiene el puntaje posible por pregunta en función de la cantidad de preguntas
    private fun getPossibleScorePerQuestion(totalQuestions: Int): Int {
        return when (totalQuestions) {
            25 -> 100 // Puntaje por pregunta con 5 preguntas
            50 -> 250 // Puntaje por pregunta con 10 preguntas
            100 -> 500 // Puntaje por pregunta con 20 preguntas
            else -> 0 // Valor predeterminado en caso de que el número de preguntas no coincida con ninguno de los casos
        }
    }


    private fun isImpossibleToWin(score: Int, totalQuestions: Int, remainingQuestions: Int): Boolean {
        val maxPossibleScore = score + (remainingQuestions * getPossibleScorePerQuestion(totalQuestions))
        val minRequiredScore = 1000
        return maxPossibleScore < minRequiredScore
    }








}
