package com.example.todolist.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao {
    @Insert
    fun insert(taskEntry: TaskEntry)

    @Delete
    fun delete(taskEntry: TaskEntry)

    @Update
    fun update(taskEntry: TaskEntry)

    @Query("DELETE FROM task_table")
    fun deleteAll()

    @Query("SELECT * FROM task_table ORDER BY timestamp DESC")
    fun getAllTasks(): LiveData<List<TaskEntry>>

    @Query("SELECT * FROM task_table ORDER BY priority ASC")
    fun getAllPriorityTasks(): LiveData<List<TaskEntry>>

    @Query("SELECT * FROM task_table WHERE title LIKE :searchQuery ORDER BY timeStamp DESC")
    fun searchDatabase(searchQuery: String): LiveData<List<TaskEntry>>
}