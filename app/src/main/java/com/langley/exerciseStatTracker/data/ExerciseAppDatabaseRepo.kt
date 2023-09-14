package com.langley.exerciseStatTracker.data

import androidx.lifecycle.LiveData

class ExerciseAppDatabaseRepo(
    private val exerciseDefDao: ExerciseDefDao,
    private val exerciseRecordDao: ExerciseRecordDao,
    private val exerciseRoutineDao: ExerciseRoutineDao,
    private val exerciseScheduleDao: ExerciseScheduleDao,
    private val userRecordDao: UserRecordDao
) {
    val readExerciseDefs: LiveData<List<ExerciseDef>> = exerciseDefDao.readAllData()
    val readExerciseRecords: LiveData<List<ExerciseRecord>> = exerciseRecordDao.readAllData()
    val readExerciseRoutines: LiveData<List<ExerciseRoutine>> = exerciseRoutineDao.readAllData()
    val readExerciseSchedules: LiveData<List<ExerciseSchedule>> = exerciseScheduleDao.readAllData()
    val readUserRecords: LiveData<List<UserRecord>> = userRecordDao.readAllData()

    suspend fun addExerciseDef(exerciseDef: ExerciseDef){
        exerciseDefDao.addExerciseDef(exerciseDef)
    }
    suspend fun addExerciseRecord(exerciseRecord: ExerciseRecord){
        exerciseRecordDao.addExerciseRecord(exerciseRecord)
    }
    suspend fun addExerciseRoutine(exerciseRoutine: ExerciseRoutine){
        exerciseRoutineDao.addExerciseRoutine(exerciseRoutine)
    }
    suspend fun addExerciseSchedule(exerciseSchedule: ExerciseSchedule){
        exerciseScheduleDao.addExerciseSchedule(exerciseSchedule)
    }
    suspend fun addUserRecord(userRecord: UserRecord){
        userRecordDao.addUserRecord(userRecord)
    }

    suspend fun getUserById(userId: Int): UserRecord{
        for (user in readUserRecords.value!!){
            if (userId == user.id) return user
        }
        return UserRecord(-1,"Unknown User", "0","0")
    }
}