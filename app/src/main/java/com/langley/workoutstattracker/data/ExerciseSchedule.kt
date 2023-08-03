package com.langley.workoutstattracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_schedules_table")
data class ExerciseSchedule(
    @PrimaryKey
    val id: Int,
    val scheduleName: String,

    // Ordered list of exercise routines as comma separated values
    val routinesCSV: String
) {
}