package com.example.projeto_final_recode_android.repository

import androidx.lifecycle.LiveData
import com.example.projeto_final_recode_android.data.db.dao.insertCourseDAO
import com.example.projeto_final_recode_android.data.db.entity.insertCourseEntity

class DataBaseDataSource(
    private val insertCourseDAO: insertCourseDAO
) : CourseRepository {
    override suspend fun insertCourse(name: String): Long {
        val courseInsert = insertCourseEntity(
            name = name
        )
        return insertCourseDAO.insert(courseInsert)
    }

    override suspend fun updateCourse(id: Long, name: String) {
        val courseUpdate = insertCourseEntity(
            id = id,
            name = name
        )
        insertCourseDAO.update(courseUpdate)
    }

    override suspend fun deleteCourse(id: Long) {
        insertCourseDAO.delete(id)
    }

    override suspend fun deleteAllCourses() {
        insertCourseDAO.deleteAll()
    }

    override suspend fun getAllCourses(): LiveData<List<insertCourseEntity>> {
        return insertCourseDAO.getAll()
    }
}