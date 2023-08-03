package com.langley.workoutstattracker.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao

interface ExerciseRecordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExerciseRecord(exerciseRecord: ExerciseRecord)

    @Query("SELECT * FROM exercise_records_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<ExerciseRecord>>

}