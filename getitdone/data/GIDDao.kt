package com.example.getitdone.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DoneDao {

    @Query("Select * FROM ToDo ORDER BY id DESC")
    fun getAllToDo(): kotlinx.coroutines.flow.Flow<List<GetItDone>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todo: GetItDone)

    @Update
    suspend fun update(todo: GetItDone)

    @Delete
    suspend fun delete(todo: GetItDone)
}
