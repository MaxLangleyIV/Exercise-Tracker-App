package com.langley.exerciseStatTracker.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExerciseRoutineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExerciseRoutine(exerciseRoutine: ExerciseRoutine)

    @Query("SELECT * FROM exercise_routines_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<ExerciseRoutine>>
}