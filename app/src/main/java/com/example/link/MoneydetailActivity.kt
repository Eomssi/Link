package com.example.link

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
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
    lateinit var txt_total2: TextView

    //DB 변수 선언
    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase
    var total_payment: Int = 0


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
        txt_total2 = findViewById(R.id.txt_total2)

        //설정한 예산 불러오기
        loadData()

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

        //예산 금액 '입력' 버튼을 눌렀을 때
        btn_set_budget.setOnClickListener {
            txt_budget.text = edtxt_set_budget.text
            txt_budget2.text = edtxt_set_budget.text

            saveData(txt_budget.text.toString().toInt(),
                txt_budget2.text.toString().toInt(),
                edtxt_set_budget.text.toString().toInt())

        }

        //subaddDB 연동
        dbManager = DBManager(this, "subaddDB", null, 1)

        //subaddDB의 payment 데이터 총합(현재까지 결제한 총 금액) 조회, txt_total2 창에 출력
        sqlitedb = dbManager.readableDatabase   //읽기
        var cursor: Cursor      //커서 선언
        //payment의 총합 조회
        cursor = sqlitedb.rawQuery("SELECT SUM(payment) FROM subaddDB;", null)
        while(cursor.moveToNext()) {
            total_payment = cursor.getInt(cursor.getColumnIndex("SUM(payment)"))
            txt_total2.text = total_payment.toString()
        }

        //커서 닫기
        cursor.close()
        sqlitedb.close()
        dbManager.close()

        //"M월 예산"부분 출력 위해 현재 몇 달인지 M 불러오기
        val current = LocalDateTime.now()
        val mFormatter = DateTimeFormatter.ofPattern("M", Locale("ko", "kr"))
        val mFormatted = current.format(mFormatter) //현재시간에 지정해놓은 형식 대입

        txt_month2.setText(mFormatted) //지정해놓은 형식으로 텍스트 입력

    }

    //예산 데이터 저장
    private fun saveData(budget1: Int,budget2: Int, budget3:Int){
        var pref = this.getPreferences(0)
        var editor = pref.edit()

        editor.putInt("KEY_BUDGET1", txt_budget.text.toString().toInt()).apply()
        editor.putInt("KEY_BUDGET2", txt_budget2.text.toString().toInt()).apply()
        editor.putInt("KEY_BUDGET3", edtxt_set_budget.text.toString().toInt()).apply()

    }

    //예산 데이터 불러오기
    private fun loadData() {
        var pref = this.getPreferences(0)
        var budget1 = pref.getInt("KEY_BUDGET1", 0)
        var budget2 = pref.getInt("KEY_BUDGET2", 0)
        var budget3 = pref.getInt("KEY_BUDGET3", 0)


        if(budget1 !=0 && budget2 !=0 && budget2 !=0){
            txt_budget.setText(budget1.toString())
            txt_budget2.setText(budget2.toString())
            edtxt_set_budget.setText(budget3.toString())
        }
    }

}