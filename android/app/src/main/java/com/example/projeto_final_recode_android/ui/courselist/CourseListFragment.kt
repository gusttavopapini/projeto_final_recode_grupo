package com.example.projeto_final_recode_android.ui.courselist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.projeto_final_recode_android.R
import com.example.projeto_final_recode_android.data.db.entity.insertCourseEntity
import kotlinx.android.synthetic.main.course_list_fragment.*

class CourseListFragment : Fragment(R.layout.course_list_fragment) {

    private lateinit var viewModel: CourseListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val courseListAdapter = CourseListAdapter(
            listOf(
                insertCourseEntity(1,"gustavo"),
                insertCourseEntity(2,"alice")
            )
        )

        recycler_course.run{
            setHasFixedSize(true)
            adapter = courseListAdapter
        }
    }

}