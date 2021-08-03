package com.example.link

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {

    //xml파일에서 사용한 위젯을 위한 변수 선언
    lateinit var btn_show_subchart: ImageButton
    lateinit var btn_show_mndetail: ImageButton
    lateinit var txt_month: TextView
    lateinit var txt_MMdd: TextView


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //위에서 선언한 변수를 위젯과 연동
        btn_show_subchart = findViewById<ImageButton>(R.id.btn_show_subchart)
        btn_show_mndetail = findViewById<ImageButton>(R.id.btn_show_mndetail)
        txt_month = findViewById<TextView>(R.id.txt_month)
        txt_MMdd = findViewById<TextView>(R.id.txt_MMdd)

        //버튼 클릭 시 구독서비스등록 화면으로 전환
        btn_show_subchart.setOnClickListener {
            val intent = Intent(this, SubchartActivity::class.java)
            startActivity(intent)
        }

        //버튼 클릭 시 예산분석 화면으로 전환
        btn_show_mndetail.setOnClickListener {
            val intent = Intent(this, MoneydetailActivity::class.java)
            startActivity(intent)
        }

        val current = LocalDateTime.now()
        val mFormatter = DateTimeFormatter.ofPattern("M", Locale("ko", "kr"))
        val mFormatted = current.format(mFormatter)

        val mmddFormatter = DateTimeFormatter.ofPattern("MM/dd", Locale("ko", "kr"))
        val mmddFormatted = current.format(mmddFormatter)

        txt_month.setText(mFormatted)
        txt_MMdd.setText(mmddFormatted)
    }
}