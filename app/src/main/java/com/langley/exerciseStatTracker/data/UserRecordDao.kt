package com.langley.exerciseStatTracker.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserRecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserRecord(userRecord: UserRecord)

    @Query("SELECT * FROM user_records_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<UserRecord>>

    @Query("SELECT * FROM user_records_table WHERE id=:id")
    fun findUserByID(id:Int): LiveData<UserRecord>
}