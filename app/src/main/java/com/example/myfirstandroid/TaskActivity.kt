package com.example.myfirstandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class TaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)
        val titleTextView = findViewById<TextView>(R.id.taskTitle)
        val bodyTextView = findViewById<TextView>(R.id.taskBody)
        val goBackButton = findViewById<Button>(R.id.goBackButton)

        titleTextView.text = intent.getStringExtra("title")
        bodyTextView.text = intent.getStringExtra("task")
        goBackButton.setOnClickListener {
            finish()
        }

    }
}





























