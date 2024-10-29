package com.example.searchinlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private var students: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    // ViewHolder class to hold views
    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val mssvTextView: TextView = itemView.findViewById(R.id.mssvTextView)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.nameTextView.text = student.name
        holder.mssvTextView.text = student.mssv
    }

    // Return the size of the dataset (invoked by the layout manager)
    override fun getItemCount() = students.size

    // Method to update the list
    fun updateList(newStudents: List<Student>) {
        students = newStudents
        notifyDataSetChanged() // Notify the adapter to refresh the views
    }
}
