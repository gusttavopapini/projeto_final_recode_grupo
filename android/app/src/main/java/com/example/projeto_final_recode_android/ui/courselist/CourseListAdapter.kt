package com.example.projeto_final_recode_android.ui.courselist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_final_recode_android.R
import com.example.projeto_final_recode_android.data.db.entity.insertCourseEntity
import kotlinx.android.synthetic.main.insert_course.view.*
import kotlinx.android.synthetic.main.list_item.view.*

class CourseListAdapter(
    private val courses: List<insertCourseEntity>
) : RecyclerView.Adapter<CourseListAdapter.CourseListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseListViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.list_item, parent, false)

        return CourseListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseListViewHolder, position: Int) {
        holder.bindView(courses[position])
    }

    override fun getItemCount() = courses.size

    class CourseListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewCourseName : TextView = itemView.text_course_name

        fun bindView(course: insertCourseEntity){
            textViewCourseName.text = course.name
        }

    }
}