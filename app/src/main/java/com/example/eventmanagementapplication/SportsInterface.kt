package com.example.eventmanagementapplication

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface SportsInterface {

    @Insert
    fun insertTodo(sportsEntity: SportsEntity)

    @Query("SELECT*FROM SportsEntity")
    fun getList():List<SportsEntity>

    @Update
    fun updateTodoEntity(sportsEntity: SportsEntity)


    @Delete
    fun deleteTodoEntity(sportsEntity: SportsEntity)


}