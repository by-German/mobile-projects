package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    // late init: permits that a variable be will null
    private lateinit var questions: ArrayList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignQuestion()
        setupView()
    }

    private fun setupView() {
        // link of components from view for id (first way)
        val btnYes = findViewById<Button>(R.id.btn_yes)
        val btnNo = findViewById<Button>(R.id.btn_no)
        val btnNext = findViewById<Button>(R.id.btn_next)
        val txtQuestion = findViewById<TextView>(R.id.txt_question)
        var position = 0

        txtQuestion.text = questions[position].sentence

        btnNext.setOnClickListener {
            // TODO: add system points in other view
            if (position + 1 < questions.size) {
                txtQuestion.text = questions[++position].sentence
            }
        }

        btnYes.setOnClickListener {
            if (questions[position].answer) {
                Toast.makeText(this, "is correct!!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "is incorrect!! :c", Toast.LENGTH_SHORT).show()
            }
        }

        btnNo.setOnClickListener {
            if (!questions[position].answer) {
                Toast.makeText(this, "is correct!!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "is incorrect!! :c", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun assignQuestion() {
        questions = ArrayList()
        questions.add(Question("es lima la capital de Chile", false))
        questions.add(Question("es lima la capital de Peru", true))
        questions.add(Question("es el sol una estrella", true))
    }


}