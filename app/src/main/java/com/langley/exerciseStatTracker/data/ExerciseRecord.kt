package com.langley.exerciseStatTracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_records_table")
data class ExerciseRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val date: String,
    val name: String,
    val weightUsed: Int,
    val repsCompleted: Int,
    val rpe: Int,
    val description: String,
    val userId: Int,
    val notes: String
    ) {
}