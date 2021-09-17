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
        val txtPoints = findViewById<TextView>(R.id.txt_score_value)
        var position = 0
        var points = 0

        txtQuestion.text = questions[position].sentence

        btnNext.setOnClickListener {
            // pass to next question
            txtPoints.text = points.toString()

            if (position + 1 < questions.size) {
                txtQuestion.text = questions[++position].sentence
            } else {
                position = 0
                txtQuestion.text = questions[position].sentence
            }
        }

        btnYes.setOnClickListener {
            if (questions[position].answer) {
                Toast.makeText(this, "is correct!!", Toast.LENGTH_SHORT).show()
                points += 10
            } else {
                Toast.makeText(this, "is incorrect!! :c", Toast.LENGTH_SHORT).show()
                points -= 10
            }
            btnNext.callOnClick()
        }

        btnNo.setOnClickListener {
            if (!questions[position].answer) {
                Toast.makeText(this, "is correct!!", Toast.LENGTH_SHORT).show()
                points += 10
            } else {
                Toast.makeText(this, "is incorrect!! :c", Toast.LENGTH_SHORT).show()
                points -= 10
            }
            btnNext.callOnClick()
        }
    }

    private fun assignQuestion() {
        questions = ArrayList()
        questions.add(Question("Es lima la capital de Chile", false))
        questions.add(Question("Es lima la capital de Peru", true))
        questions.add(Question("Es el sol una estrella", true))
        questions.add(Question("Java es un lenguaje de programcion", true))
        questions.add(Question("HTML es un lenguaje de programacion", false))
    }


}