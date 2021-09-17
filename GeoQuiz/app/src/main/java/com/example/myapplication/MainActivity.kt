package com.example.myapplication

import android.content.Intent
import android.graphics.Color
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
        var color = "#000000";
        var points = 0

        txtQuestion.text = questions[position].sentence

        btnNext.setOnClickListener {
            // pass to next question
            txtPoints.text = points.toString()
            txtPoints.setTextColor(Color.parseColor(color))

            if (position + 1 < questions.size) {
                txtQuestion.text = questions[++position].sentence
            } else {
                position = 0
                txtQuestion.text = questions[position].sentence
            }

            if (points == 10 * questions.size) {
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("result", "Congratulations\nScore: $points")
                }
                startActivity(intent)
            }

        }


        btnYes.setOnClickListener {
            if (questions[position].answer) {
                Toast.makeText(this, "is correct!!", Toast.LENGTH_SHORT).show()
                points += 10
                color = "#4CAF50"
            } else {
                Toast.makeText(this, "is incorrect!! :c", Toast.LENGTH_SHORT).show()
                points -= 10
                color = "#F44336"

            }
            btnNext.callOnClick()
        }

        btnNo.setOnClickListener {
            if (!questions[position].answer) {
                Toast.makeText(this, "is correct!!", Toast.LENGTH_SHORT).show()
                points += 10
                color = "#4CAF50"
            } else {
                Toast.makeText(this, "is incorrect!! :c", Toast.LENGTH_SHORT).show()
                points -= 10
                color = "#F44336"
            }
            btnNext.callOnClick()
        }
    }

    private fun assignQuestion() {
        questions = ArrayList()
        questions.add(Question("Es lima la capital de Chile", false))
        questions.add(Question("Es lima la capital de Peru", true))
        questions.add(Question("Es santiago la capital de Chile", true))
        questions.add(Question("Es la Paz la capital de Bolivia", true))
        questions.add(Question("Es santiago la capital de Peru", false))
    }


}