package com.langley.exerciseStatTracker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.langley.exerciseStatTracker.R
import com.langley.exerciseStatTracker.adapters.ExerciseLibraryAdapter
import com.langley.exerciseStatTracker.data.ExerciseAppViewModel

class ExerciseLibraryFragment : Fragment() {

    private lateinit var viewModel: ExerciseAppViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_exercise_library, container, false)

        //Setup recycler view and adapter
        val adapter = ExerciseLibraryAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //Setup view model
        val viewModel = ViewModelProvider(this)[ExerciseAppViewModel::class.java]






        return view
    }

}