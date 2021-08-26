package com.example.myfirstandroid

import CustomAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OpenTask {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        val newButton = findViewById<ImageView>(R.id.newButton)
        val subButton = findViewById<ImageView>(R.id.subButton)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val todo = findViewById<LinearLayout>(R.id.todo)
        val editText = findViewById<EditText>(R.id.editText)
        val editText2 = findViewById<EditText>(R.id.editText2)

        val data = ArrayList<ItemsViewModel>()
        val adapter = CustomAdapter(data, this)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        newButton.setOnClickListener {
            todo.visibility = View.VISIBLE
            newButton.visibility = View.GONE
            subButton.visibility = View.VISIBLE
        }

        subButton.setOnClickListener {
            todo.visibility = View.GONE
            newButton.visibility = View.VISIBLE
            subButton.visibility = View.GONE
        }

        editText.addTextChangedListener{
            if(editText.text.toString() != "" && editText2.text.toString() != ""){
                saveButton.visibility = View.VISIBLE
            }
            else{
                saveButton.visibility = View.GONE
            }
        }

        editText2.addTextChangedListener{
            if(editText.text.toString() != "" && editText2.text.toString() != ""){
                saveButton.visibility = View.VISIBLE
            }
            else{
                saveButton.visibility = View.GONE
            }
        }

        saveButton.setOnClickListener {
            data.add(ItemsViewModel(editText.text.toString(), editText2.text.toString()))
            todo.visibility = View.GONE
            newButton.visibility = View.VISIBLE
            subButton.visibility = View.GONE
            editText.text.clear()
            editText2.text.clear()

            adapter.notifyDataSetChanged()
        }

    }

    override fun taskOpener(task: ItemsViewModel) {
            val taskIntent = Intent(this, TaskActivity::class.java)
            taskIntent.putExtra("title", task.text)
            taskIntent.putExtra("task", task.text2)

            startActivity(taskIntent)
    }
}

