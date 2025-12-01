package com.example.getitdone.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ToDo")
data class GetItDone(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var title: String,
    var details: String,
    var isDone: Boolean = false
)