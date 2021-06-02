package com.example.projeto_final_recode_android.ui.inserts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.projeto_final_recode_android.R
import com.example.projeto_final_recode_android.data.db.AppDataBase
import com.example.projeto_final_recode_android.data.db.dao.insertCourseDAO
import com.example.projeto_final_recode_android.extension.hideKeyboard
import com.example.projeto_final_recode_android.repository.CourseRepository
import com.example.projeto_final_recode_android.repository.DataBaseDataSource
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.insert_course.*

class insertCourse : Fragment(R.layout.insert_course) {

    private val viewModel: insertCourseViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val insertCourseDAO: insertCourseDAO =
                    AppDataBase.getInstance(requireContext()).insertCourseDAO

                val repository: CourseRepository = DataBaseDataSource(insertCourseDAO)
                return insertCourseViewModel(repository) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeEvents()
        setListeners()
    }

    private fun observeEvents() {
        viewModel.insertCourseStateEventData.observe(viewLifecycleOwner) { insertCourseState ->
            when (insertCourseState) {
                is insertCourseViewModel.InsertCourseState.Inserted -> {
                    clearFields()
                    hideKeyboard()
                    requireView().requestFocus()
                }
            }
        }

        viewModel.messageEventData.observe(viewLifecycleOwner) { stringResId ->
            Snackbar.make(requireView(), stringResId, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun clearFields() {
        input_name_course.text?.clear()
    }

    private fun hideKeyboard() {
        val parentActivity = requireActivity()
        if (parentActivity is AppCompatActivity) {
            parentActivity.hideKeyboard()
        }
    }

    private fun setListeners() {
        button_insert_course.setOnClickListener {
            val name = input_name_course.text.toString()

            viewModel.addCourse(name)
        }
    }
}