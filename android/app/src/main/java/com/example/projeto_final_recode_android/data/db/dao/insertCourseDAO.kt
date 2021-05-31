package com.example.projeto_final_recode_android.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.projeto_final_recode_android.data.db.entity.insertCourseEntity


@Dao
interface insertCourseDAO {

    @Insert
    suspend fun insert(subscriber: insertCourseEntity): Long

    @Update
    suspend fun update(subscriber: insertCourseEntity)

    @Query("DELETE FROM insertCourse WHERE id = :id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM insertCourse")
    suspend fun deleteAll()

    @Query("SELECT * FROM insertCourse")
    fun getAll(): LiveData<List<insertCourseEntity>>
}