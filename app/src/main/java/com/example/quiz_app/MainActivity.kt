package com.example.quiz_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var num: Int = 0 // 문제
    var score: Int = 0 // 점수

    val question = arrayOf(
        Question(R.string.q_01, true),
        Question(R.string.q_02, false),
        Question(R.string.q_03, true),
        Question(R.string.q_04, false),
        Question(R.string.q_05, true),
        Question(R.string.q_06, false),
        Question(R.string.q_07, false),
        Question(R.string.q_08, true),
        Question(R.string.q_09, true),
        Question(R.string.q_10, false)
    )


    var q_answer = mutableListOf<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonOClicked(v: View) {
        q_answer.add(true)

        if (num < 10) {
            quiz.setText(question[num].quizNum)
            if(num == 0) {
                Toast.makeText(this, R.string.start_quiz, Toast.LENGTH_SHORT).show()
            }else {
                grading(num)
            }

            cost!!.text = "${num + 1} / 10"
            num++

        } else if (num == 10) {
            grading(num)
            grade(score)
            num++
        } else {
            Toast.makeText(this, R.string.al_quiz, Toast.LENGTH_SHORT).show()
            cost!!.setText(R.string.com_quiz)
        }
    }


    fun onButtonXClicked(v: View) {
        q_answer.add(false)

        if (num < 10) {
            quiz.setText(question[num].quizNum)
            if(num == 0) {
                Toast.makeText(this, R.string.start_quiz, Toast.LENGTH_SHORT).show()
            }else {
                grading(num)
            }

            cost!!.text = "${num + 1} / 10"
            num++

        } else if (num == 10) {
            grading(num)
            grade(score)
            num++
        } else {
            Toast.makeText(this, R.string.al_quiz, Toast.LENGTH_SHORT).show()
            cost!!.setText(R.string.com_quiz)
        }
    }

    fun grade(score: Int) {
        when (score) {
            in 0..20 -> quiz.setTextColor(Color.RED)
            in 21..50 -> quiz.setTextColor(Color.argb(255, 255, 127, 0))
            in 51..80 -> quiz.setTextColor(Color.YELLOW)
            in 81..100 -> quiz.setTextColor(Color.BLACK)
        }
        quiz.textSize += 10
        cost!!.setText(R.string.com_quiz)
        quiz!!.text = score.toString() + "점"
    }

    fun grading(num: Int) {
        if(question[num - 1].answer == q_answer[num]){
                Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show()
                score += 10
        }else{
            Toast.makeText(this, R.string.un_correct, Toast.LENGTH_SHORT).show()
        }
    }
}


