package com.langley.exerciseStatTracker.fragments

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
    private lateinit var user: UserRecord
    private lateinit var userList: List<UserRecord>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appViewModel = ViewModelProvider(this)[ExerciseAppViewModel::class.java]
       // appViewModel.readUserRecords().observe(viewLifecycleOwner,{})
        binding = FragmentHomeBinding.bind(view)

        user = findUser(view)



        binding.selectWorkoutButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_exerciseLibraryFragment)
        }

        binding.exerciseLogButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_completedExercisesFragment)
        }
        binding.profileButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_userProfileFragment)
        }


    }

    private fun findUser(view: View): UserRecord {
        val userPrefs = view.context.getSharedPreferences("user_prefs",MODE_PRIVATE)
        val currentUserId = userPrefs.getInt("user_id",-1)

        if (currentUserId == -1){
            //Toast.makeText(requireContext(), "id = -1", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.action_homeFragment_to_userSetupFragment)
        }
        else {
            val userList = appViewModel.readUserRecords().value

            if (userList != null){

                for (currentUser in userList){
                    if (currentUser.id == currentUserId){
                        return currentUser
                    }
                }

            }

            return UserRecord(-1,"","","")
        }
        return UserRecord(-1,"","","")
    }

    private fun getUserById(userID: Int): UserRecord{
        for (user in userList){
            if (userID == user.id) return user
        }

        return UserRecord(-1,",","","")
    }



}