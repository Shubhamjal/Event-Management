package com.example.eventmanagementapplication

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class SportsEntity(
@PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var Title:String?="",
    var Status:String?="",
    var Date:String?="",
    var Location:String?="",

)
