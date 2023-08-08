package com.langley.exerciseStatTracker.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExerciseDefDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExerciseDef(exerciseDef: ExerciseDef)

    @Query("SELECT * FROM exercise_definitions_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<ExerciseDef>>
}