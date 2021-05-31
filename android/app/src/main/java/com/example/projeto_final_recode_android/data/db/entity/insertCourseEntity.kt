package com.example.projeto_final_recode_android.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "insertCourse")
data class insertCourseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    val name: String
)