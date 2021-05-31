package com.example.projeto_final_recode_android.repository

import androidx.lifecycle.LiveData
import com.example.projeto_final_recode_android.data.db.entity.insertCourseEntity

interface CourseRepository {

    suspend fun insertCourse(name: String): Long

    suspend fun updateCourse(id: Long, name: String)

    suspend fun deleteCourse(id: Long)

    suspend fun deleteAllCourses()

    suspend fun getAllCourses(): LiveData<List<insertCourseEntity>>
}