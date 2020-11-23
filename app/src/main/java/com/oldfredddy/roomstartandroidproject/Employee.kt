package com.oldfredddy.roomstartandroidproject

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Employee(
    @PrimaryKey
    val id: Long?,

    val name: String,

    var salary: Int
)