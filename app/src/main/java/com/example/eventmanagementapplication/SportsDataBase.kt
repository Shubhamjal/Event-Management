package com.example.eventmanagementapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [SportsEntity::class], version = 1, exportSchema = true)
abstract class SportsDataBase:RoomDatabase() {
    abstract fun sportsInterface():SportsInterface

    companion object{
        private var sportsDataBase : SportsDataBase?= null

        fun getInstance(context: Context): SportsDataBase{
            if(sportsDataBase == null){
                sportsDataBase = Room.databaseBuilder(context,
                    SportsDataBase::class.java,
                    "NotesDatabase")
                    .allowMainThreadQueries()
                    .build()
            }
            return sportsDataBase!!
        }
    }

}