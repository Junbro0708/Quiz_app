package com.example.quiz_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var num: Int = 1
    var score: Int = 0
    var cost_num: Int = 0


    private val text = hashMapOf(1 to "글로벌미디어학부는 IT대학이다.",
        2 to "숭실대학교는 상도역에 있다.",
        3 to "준형이는 24살이다.",
        4 to "종헌이형은 올해 졸업작품을 한다.",
        5 to "준형이는 크게 될 인물이다.",
        6 to "영준이형은 28살이다.",
        7 to "종헌이형은 시원스쿨을 한다.",
        8 to "롤을 제일 잘하는 사람은 준형이다.",
        9 to "우리는 언타이틀이다.",
        10 to "안드로이드 스터디는 재미없다."
    )

    val text_a = listOf(2, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0)
    var text_c = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun onButtonOClicked(v: View) {
        quiz!!.text = text[num]
        num++
        text_c.add(1)

        if(num == 12) {
            for(i in 1 .. 10) {
                if(text_a[i] == text_c[i]) {
                    score += 10
                }
            }
            when(score) {
                in 0 .. 20 -> quiz.setTextColor(Color.RED)
                in 21 .. 50 -> quiz.setTextColor(Color.argb(255,255, 127,0))
                in 51 .. 80 -> quiz.setTextColor(Color.YELLOW)
                in 81 .. 100 -> quiz.setTextColor(Color.BLACK)
            }
            quiz.textSize += 10
        }

        if(num >= 12) {
            Toast.makeText(this, "문제를 다 풀었습니다.", Toast.LENGTH_SHORT).show()
            quiz!!.text = score.toString() + "점"

        }
        cost_num++
        cost!!.text = "$cost_num / 10"

        if(cost_num == 11) {
            cost!!.text = " 문제풀기 성공!! "
        }
    }

    fun onButtonXClicked(v: View) {
        quiz!!.text = text[num]
        num++
        text_c.add(0)

        if(num == 12) {
            for(i in 1 .. 10) {
                if(text_a[i] == text_c[i]) {
                    score += 10
                }

            }
            when(score) {
                in 0 .. 20 -> quiz.setTextColor(Color.RED)
                in 21 .. 50 -> quiz.setTextColor(Color.argb(255,255, 127,0))
                in 51 .. 80 -> quiz.setTextColor(Color.YELLOW)
                in 81 .. 100 -> quiz.setTextColor(Color.BLACK)
            }
            quiz.textSize += 10
        }

        if(num >= 12) {
            Toast.makeText(this, "문제를 다 풀었습니다.", Toast.LENGTH_SHORT).show()
            quiz!!.text = score.toString() + "점"
        }
        cost_num++
        cost!!.text = "$cost_num / 10"

        if(cost_num == 11) {
            cost!!.text = " 문제풀기 성공!! "
        }
    }

}
