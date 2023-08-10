package com.langley.exerciseStatTracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.langley.exerciseStatTracker.R
import com.langley.exerciseStatTracker.data.ExerciseDef

class ExerciseLibraryAdapter: RecyclerView.Adapter<ExerciseLibraryAdapter.ExerciseViewHolder>() {
    class ExerciseViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameView: TextView
        val bodyPartsView: TextView

        init {
            nameView = view.findViewById(R.id.exerciseName)
            bodyPartsView = view.findViewById(R.id.exerciseBodyParts)
        }
    }


    private var exerciseList = emptyList<ExerciseDef>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        return ExerciseViewHolder((LayoutInflater.from(parent.context)).inflate(R.layout.exercise_def_row, parent, false ))
    }

    override fun getItemCount(): Int {
        return exerciseList.size
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val currentItem = exerciseList[position]

        holder.nameView.text = currentItem.name
        holder.bodyPartsView.text = currentItem.bodyRegion



    }
}




