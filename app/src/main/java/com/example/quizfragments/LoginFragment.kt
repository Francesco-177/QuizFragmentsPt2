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
private const val LOG_PARAM1 = "param1"
private const val LOG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val firstName: EditText?
        get() = view?.findViewById(R.id.first_name)

    private val lastName: EditText?
        get() = view?.findViewById(R.id.last_name)

    private val email: EditText?
        get() = view?.findViewById(R.id.email)

    private val phone: EditText?
        get() = view?.findViewById(R.id.phone)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(LOG_PARAM1)
            param2 = it.getString(LOG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }


    fun getPersonalDetails(){

        val startButton = view?.findViewById<Button>(R.id.start_button)

        startButton?.setOnClickListener {
            val firstNameText = firstName?.text?.toString()?.trim() ?: ""
            val lastNameText = lastName?.text?.toString()?.trim() ?: ""
            val emailText = email?.text?.toString() ?: ""
            val phoneText = phone?.text?.toString() ?: ""


            if (firstNameText.isEmpty() || lastNameText.isEmpty() || emailText.isEmpty() || phoneText.isEmpty()) {
                Toast.makeText(requireContext(), getString(R.string.add_text_validation), Toast.LENGTH_LONG).show()
            } else {

                val fullName = "$firstNameText $lastNameText"
                //Constants.fullName = fullName

                val intent = Intent(context, DifficultyActivity::class.java)
                intent.putExtra("fullName",fullName)
                startActivity(intent)

                hideKeyboard()
                //clear
                clearInputFields()

            }
        }
    }
    private fun clearInputFields() {
        firstName?.text?.clear()
        lastName?.text?.clear()
        email?.text?.clear()
        phone?.text?.clear()
    }


    private fun hideKeyboard() {
        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().windowToken, 0)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic


        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(LOG_PARAM1, param1)
                    putString(LOG_PARAM2, param2)
                }
            }
    }
}