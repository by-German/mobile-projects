package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val message = intent.getStringExtra("result")
        val btnBack = findViewById<Button>(R.id.btn_back)

        findViewById<TextView>(R.id.txt_result).apply {
            text = message
        }

        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}