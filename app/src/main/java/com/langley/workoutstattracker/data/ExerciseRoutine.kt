package com.langley.workoutstattracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_routines_table")
data class ExerciseRoutine(
    @PrimaryKey
    val id: Int,
    val routineName: String,

    //Names of the exercises to be performed as comma separated values
    val exercisesCSV: String,
    //The goal reps to complete per exercise (matches order of exercisesCSV)
    val repsCSV: String
) {
}