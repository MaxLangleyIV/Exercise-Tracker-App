package com.langley.exerciseStatTracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [
    ExerciseRecord::class,
    ExerciseDef::class,
    ExerciseRoutine::class,
    ExerciseSchedule::class,
    UserRecord::class
                     ], version = 1, exportSchema = false)
abstract class ExerciseAppDatabase: RoomDatabase() {

    abstract fun exerciseRecordDao(): ExerciseRecordDao
    abstract fun exerciseDefDao(): ExerciseDefDao
    abstract fun exerciseRoutineDao(): ExerciseRoutineDao
    abstract fun exerciseScheduleDao(): ExerciseScheduleDao
    abstract fun userRecordDao(): UserRecordDao


    companion object {
        @Volatile
        private var INSTANCE: ExerciseAppDatabase? = null

        fun getDatabase(context: Context): ExerciseAppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExerciseAppDatabase::class.java,
                    "exercise_record_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}