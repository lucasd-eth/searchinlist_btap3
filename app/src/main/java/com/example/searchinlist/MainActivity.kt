// MainActivity.kt
package com.example.searchinlist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var studentAdapter: StudentAdapter
    private lateinit var studentList: MutableList<Student>
    private lateinit var recyclerView: RecyclerView
    private lateinit var editTextSearch: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các view
        recyclerView = findViewById(R.id.recyclerView)
        editTextSearch = findViewById(R.id.editTextSearch)

        // Tạo danh sách sinh viên mẫu
        studentList = mutableListOf(
            Student("Nguyen Thi Mai", "111222"),
            Student("Tran Minh Chau", "333444"),
            Student("Le Hoang Nam", "555666"),
            Student("Phan Thi Thu", "777888"),
            Student("Hoang Van Phuc", "999000"),
            Student("Nguyen Van Tu", "123123"),
            Student("Tran Thi Hoa", "456456"),
            Student("Le Van Quang", "789789"),
            Student("Phan Hoang Khoa", "147258"),
            Student("Hoang Thi Thao", "369963"),
            Student("Nguyen Van Binh", "852963"),
            Student("Tran Thi Lan", "753951"),
            Student("Le Thi Hanh", "159753"),
            Student("Phan Van Thanh", "963852"),
            Student("Hoang Minh Tu", "357159"),
            Student("Nguyen Hoang Cuong", "741852"),
            Student("Tran Thi Thanh", "258963"),
            Student("Le Van Tai", "456123"),
            Student("Phan Minh Duong", "654321"),
            Student("Hoang Thi Bich", "321654")
        )


        // Khởi tạo Adapter và RecyclerView
        studentAdapter = StudentAdapter(studentList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = studentAdapter

        // Xử lý tìm kiếm
        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filter(s.toString())
            }
        })
    }

    private fun filter(text: String) {
        val filteredList = if (text.length > 2) {
            studentList.filter {
                it.name.contains(text, ignoreCase = true) || it.mssv.contains(text)
            }
        } else {
            studentList
        }
        studentAdapter.updateList(filteredList)
    }
}
