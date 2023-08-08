package com.langley.exerciseStatTracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_definitions_table")
data class ExerciseDef(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val bodyRegion:String,
    val bodyParts:String,
    val description:String
){
}