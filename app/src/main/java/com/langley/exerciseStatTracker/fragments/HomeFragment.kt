package com.langley.exerciseStatTracker.fragments

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.langley.exerciseStatTracker.R
import com.langley.exerciseStatTracker.data.ExerciseAppViewModel
import com.langley.exerciseStatTracker.data.UserRecord
import com.langley.exerciseStatTracker.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var appViewModel: ExerciseAppViewModel
    private lateinit var binding : FragmentHomeBinding
    private  lateinit var user: UserRecord

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appViewModel = ViewModelProvider(this)[ExerciseAppViewModel::class.java]
        binding = FragmentHomeBinding.bind(view)

        //user= appViewModel.readUserRecords().

        binding.selectWorkoutButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_exerciseLibraryFragment)
        }

        binding.exerciseLogButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_completedExercisesFragment)
        }


    }

    private fun checkUserProfile(view: View,context: Context){
        val user_prefs = context.getSharedPreferences("user_prefs",MODE_PRIVATE)
        val current_user_id = user_prefs.getInt("user_id",-1)

        if (current_user_id == -1){
            view.findNavController().navigate(R.id.action_homeFragment_to_userSetupFragment)
        }
        else {

        }

    }


}