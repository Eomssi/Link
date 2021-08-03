package com.example.link

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class MoneydetailActivity : AppCompatActivity() {

    //xml파일에서 사용한 변수 선언
    lateinit var btn_plus:ImageButton
    lateinit var btn_show_main:ImageButton
    lateinit var txt_month2: TextView
    lateinit var edtxt_set_budget: EditText
    lateinit var btn_set_budget: Button
    lateinit var btn_show_set_budget: ImageButton
    lateinit var textView_5:TextView
    lateinit var txt_budget: TextView
    lateinit var txt_budget2: TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moneydetail)

        //변수와 위젯을 연동
        btn_plus = findViewById(R.id.btn_plus)
        btn_show_main = findViewById(R.id.btn_show_main)
        txt_month2 = findViewById(R.id.txt_month2)
        edtxt_set_budget = findViewById(R.id.edtxt_set_budget)
        btn_set_budget = findViewById(R.id.btn_set_budget)
        btn_show_set_budget = findViewById(R.id.btn_show_set_budget)
        textView_5 = findViewById<TextView>(R.id.textView_5)
        txt_budget = findViewById(R.id.txt_budget)
        txt_budget2 = findViewById(R.id.txt_budget2)

        //버튼 클릭 시 구독서비스등록 화면으로 이동
        btn_plus.setOnClickListener {
            val intent = Intent(this, SubchartActivity::class.java)
            startActivity(intent)
        }
        //버튼 클릭 시 메인 화면으로 이동
       btn_show_main.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        /*예산설정의 아래 꺽쇠 버튼을 눌렀을 때 안 보이던 예산입력창들을 보이게 하고
        * 다시 눌렀을 때는 보이는 예산 입력창들을 안 보이게 함*/
        btn_show_set_budget.setOnClickListener {
            if(btn_set_budget.visibility == View.GONE) {
                /*예산입력창에 속한 버튼이 gone 상태일 때 예산설정 옆 꺽쇠버튼을 누르면
                예산입력창에 속한 뷰들이 visible로 바뀐다.*/
                edtxt_set_budget.visibility = View.VISIBLE
                btn_set_budget.visibility = View.VISIBLE
                textView_5.visibility = View.VISIBLE
            }
            else{
                /*예산입력창에 속한 버튼이 gone이 아닐 때 예산설정 옆 꺽쇠버튼을 누르면
                예산입력창에 속한 뷰들이 gone으로 바뀐다.*/
                edtxt_set_budget.visibility = View.GONE
                btn_set_budget.visibility = View.GONE
                textView_5.visibility = View.GONE
            }
        }

        //쿼리문으로 수정 필요
        btn_set_budget.setOnClickListener {
            txt_budget.text=edtxt_set_budget.getText()
            txt_budget2.setText(edtxt_set_budget.getText())
        }

        //"M월 예산"부분 출력 위해 현재 몇 달인지 M 불러오기
        val current = LocalDateTime.now()
        val mFormatter = DateTimeFormatter.ofPattern("M", Locale("ko", "kr"))
        val mFormatted = current.format(mFormatter) //현재시간에 지정해놓은 형식 대입

        txt_month2.setText(mFormatted) //지정해놓은 형식으로 텍스트 입력

    }
}