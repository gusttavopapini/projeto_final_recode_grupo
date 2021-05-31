package com.example.projeto_final_recode_android.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projeto_final_recode_android.data.db.dao.insertCourseDAO
import com.example.projeto_final_recode_android.data.db.entity.insertCourseEntity


@Database(entities = [insertCourseEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract val insertCourseDAO: insertCourseDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            synchronized(this) {
                var instance: AppDataBase? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDataBase::class.java,
                        "app_database"
                    ).build()
                }

                return instance
            }
        }
    }
}