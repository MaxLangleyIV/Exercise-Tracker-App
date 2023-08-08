package com.langley.exerciseStatTracker.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.langley.exerciseStatTracker.R
import com.langley.exerciseStatTracker.data.ExerciseAppViewModel
import com.langley.exerciseStatTracker.data.UserRecord
import com.langley.exerciseStatTracker.databinding.FragmentUserSetupBinding


class UserSetupFragment : Fragment() {

    private lateinit var appViewModel: ExerciseAppViewModel
    private lateinit var binding : FragmentUserSetupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_setup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appViewModel = ViewModelProvider(this)[ExerciseAppViewModel::class.java]
        binding = FragmentUserSetupBinding.bind(view)

        binding.submitButton.setOnClickListener {
            insertUserToDatabase()
        }
        Toast.makeText(requireContext(),"BIND DONE", Toast.LENGTH_LONG).show()
    }

    private fun insertUserToDatabase(){
        val name = binding.editTextTextPersonName.text.toString()
        val birthDate = binding.editTextDate.text.toString()
        val bodyWeight = binding.editTextWeight.text.toString()

        if (checkInput(name, birthDate, bodyWeight)){

            val user = UserRecord(0, name, birthDate, bodyWeight)
            appViewModel.addUserRecord(user)
            Toast.makeText(requireContext(),"User successfully added!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_userSetupFragment_to_homeFragment)
        }
        else {
            Toast.makeText(requireContext(), "Please ensure all fields are filled.", Toast.LENGTH_SHORT).show()
        }

    }

    private fun checkInput(name: String, birthDate: String, bodyWeight : String): Boolean {
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(birthDate) || TextUtils.isEmpty(bodyWeight))
    }

}