package com.example.quiz_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var num: Int = 1 // 문제
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
        Question(R.string.q_10, false),
        Question(R.string.q_10, false),
        Question(R.string.q_10, false),
        Question(R.string.q_10, false),
        Question(R.string.q_10, false)
    )


    var q_answer = mutableListOf<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonOClicked(v: View) {
        if(num < 11) {
            quiz.setText(question[num - 1].quizNum)
            q_answer.add(true)

            when {
                num == 1 -> {
                    Toast.makeText(this, "문제 시작!", Toast.LENGTH_SHORT).show()
                }
                question[num - 2].answer == q_answer[num - 1] -> {
                    Toast.makeText(this, "정답입니다.", Toast.LENGTH_SHORT).show()
                    score += 10
                }
                else -> {
                    Toast.makeText(this, "오답입니다.", Toast.LENGTH_SHORT).show()
                }
            }

            cost!!.text = "$num / 10"
            num++

        }else if(num == 11) {
            when (score) {
                in 0..20 -> quiz.setTextColor(Color.RED)
                in 21..50 -> quiz.setTextColor(Color.argb(255, 255, 127, 0))
                in 51..80 -> quiz.setTextColor(Color.YELLOW)
                in 81..100 -> quiz.setTextColor(Color.BLACK)
            }
            quiz.textSize += 10
            cost!!.text = " 문제풀기 성공!! "
            quiz!!.text = score.toString() + "점"

            num++
        }else {
            Toast.makeText(this, "문제를 다 풀었습니다.", Toast.LENGTH_SHORT).show()
            cost!!.text = " 문제풀기 성공!! "
        }
    }



    fun onButtonXClicked(v: View) {
        if(num < 11) {
            quiz.setText(question[num - 1].quizNum)
            q_answer.add(false)

            when {
                num == 1 -> {
                    Toast.makeText(this, "문제 시작!", Toast.LENGTH_SHORT).show()
                }
                question[num - 2].answer == q_answer[num - 1] -> {
                    Toast.makeText(this, "정답입니다.", Toast.LENGTH_SHORT).show()
                    score += 10
                }
                else -> {
                    Toast.makeText(this, "오답입니다.", Toast.LENGTH_SHORT).show()
                }
            }

            cost!!.text = "$num / 10"
            num++

        }else if(num == 11) {
            when (score) {
                in 0..20 -> quiz.setTextColor(Color.RED)
                in 21..50 -> quiz.setTextColor(Color.argb(255, 255, 127, 0))
                in 51..80 -> quiz.setTextColor(Color.YELLOW)
                in 81..100 -> quiz.setTextColor(Color.BLACK)
            }
            quiz.textSize += 10
            cost!!.text = " 문제풀기 성공!! "
            quiz!!.text = score.toString() + "점"

            num++
        }else {
            Toast.makeText(this, "문제를 다 풀었습니다.", Toast.LENGTH_SHORT).show()
            cost!!.text = " 문제풀기 성공!! "
        }
        }
    }

