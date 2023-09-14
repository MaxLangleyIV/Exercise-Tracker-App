package com.langley.exerciseStatTracker.data

import android.app.Application
import androidx.appcompat.app.ActionBarDrawerToggle.Delegate
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.properties.Delegates


class ExerciseAppViewModel(application: Application): AndroidViewModel(application) {

    private val exerciseDefs: LiveData<List<ExerciseDef>>
    private val exerciseRecords: LiveData<List<ExerciseRecord>>
    private val exerciseRoutines: LiveData<List<ExerciseRoutine>>
    private val exerciseSchedules: LiveData<List<ExerciseSchedule>>
    private val userRecords: LiveData<List<UserRecord>>

    private val repository: ExerciseAppDatabaseRepo

    init {
        val exerciseAppDatabase = ExerciseAppDatabase.getDatabase(application)
        val exerciseDefDao = exerciseAppDatabase.exerciseDefDao()
        val exerciseRecordDao = exerciseAppDatabase.exerciseRecordDao()
        val exerciseRoutineDao = exerciseAppDatabase.exerciseRoutineDao()
        val exerciseScheduleDao = exerciseAppDatabase.exerciseScheduleDao()
        val userRecordDao = exerciseAppDatabase.userRecordDao()

        repository = ExerciseAppDatabaseRepo(
            exerciseDefDao,
            exerciseRecordDao,
            exerciseRoutineDao,
            exerciseScheduleDao,
            userRecordDao
        )

        exerciseDefs = repository.readExerciseDefs
        exerciseRecords = repository.readExerciseRecords
        exerciseRoutines = repository.readExerciseRoutines
        exerciseSchedules = repository.readExerciseSchedules
        userRecords = repository.readUserRecords
    }

    fun addExerciseDef(exerciseDef: ExerciseDef){
        viewModelScope.launch(Dispatchers.IO){
            repository.addExerciseDef(exerciseDef)
        }
    }

    fun readExerciseDefs(): LiveData<List<ExerciseDef>>{
        return exerciseDefs
    }

    fun addExerciseRecord(exerciseRecord: ExerciseRecord){
        viewModelScope.launch(Dispatchers.IO){
            repository.addExerciseRecord(exerciseRecord)
        }
    }

    fun readExerciseRecords(): LiveData<List<ExerciseRecord>>{
        return exerciseRecords
    }


    fun addExerciseRoutine(exerciseRoutine: ExerciseRoutine){
        viewModelScope.launch(Dispatchers.IO){
            repository.addExerciseRoutine(exerciseRoutine)
        }
    }

    fun readExerciseRoutines(): LiveData<List<ExerciseRoutine>>{
        return exerciseRoutines
    }

    fun addExerciseSchedule(exerciseSchedule: ExerciseSchedule){
        viewModelScope.launch(Dispatchers.IO){
            repository.addExerciseSchedule(exerciseSchedule)
        }
    }
    fun readExerciseSchedules(): LiveData<List<ExerciseSchedule>>{
        return exerciseSchedules
    }

    fun readUserRecords(): LiveData<List<UserRecord>>{
        return userRecords
    }

    fun addUserRecord(userRecord: UserRecord){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUserRecord(userRecord)
        }
    }

}