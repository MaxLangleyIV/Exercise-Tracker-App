package com.langley.exerciseStatTracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_records_table")
data class UserRecord(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name: String,
    val birthDate: String,
    val bodyWeight: String,
    val currentScheduleId: Int = 0,
    val currentScheduleDay : Int = 0,
) {
}
