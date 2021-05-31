package com.example.projeto_final_recode_android.ui.inserts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projeto_final_recode_android.R
import com.example.projeto_final_recode_android.repository.CourseRepository
import kotlinx.coroutines.launch

class insertCourseViewModel(
    private val repository: CourseRepository
) : ViewModel() {

    private val _courseInsertStateEventData = MutableLiveData<InsertCourseState>()
    val insertCourseStateEventData: LiveData<InsertCourseState>
        get() = _courseInsertStateEventData

    private val _messageEventData = MutableLiveData<Int>()
    val messageEventData: LiveData<Int>
        get() = _messageEventData

    fun addCourse(name: String) = viewModelScope.launch {
        try {
            val id = repository.insertCourse(name)
            if (id > 0) {
                _courseInsertStateEventData.value = InsertCourseState.Inserted
                _messageEventData.value = R.string.course_inserted_successfully
            }
        } catch (ex: Exception) {
            _messageEventData.value = R.string.course_error_to_insert
            Log.e(TAG, ex.toString())
        }
    }

    sealed class InsertCourseState {
        object Inserted : InsertCourseState()
    }

    companion object {
        private val TAG = insertCourseViewModel::class.java.simpleName
    }
}