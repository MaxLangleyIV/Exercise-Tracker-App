package com.langley.exerciseStatTracker.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExerciseScheduleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExerciseSchedule(exerciseSchedule: ExerciseSchedule)

    @Query("SELECT * FROM exercise_schedules_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<ExerciseSchedule>>
}