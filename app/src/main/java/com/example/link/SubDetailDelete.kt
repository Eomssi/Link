package com.example.link

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class SubDetailDelete : AppCompatActivity() {
    //DB 변수 선언
    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase

    //위젯 변수 선업
    lateinit var btnUpdate: Button
    lateinit var btnDelete: Button
    lateinit var tvName: TextView
    lateinit var tvPayment: TextView
    lateinit var tvCategory: TextView
    lateinit var payYY: TextView
    lateinit var payMM: TextView
    lateinit var payDD: TextView
    lateinit var tvCycleYY: TextView
    lateinit var tvCycleMM: TextView
    lateinit var tvCycleDD: TextView
    lateinit var notiYY: TextView
    lateinit var notiMM: TextView
    lateinit var notiDD: TextView
    lateinit var tvmemo: TextView
    lateinit var btnback: ImageButton

    //lateinit var str_name: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_detail_delete)

        //위젯 변수 연결
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)
        tvName = findViewById(R.id.tvName)
        tvPayment = findViewById(R.id.tvPayment)
        tvCategory = findViewById(R.id.tvCategory)
        payYY = findViewById(R.id.payYY)
        payMM = findViewById(R.id.payMM)
        payDD = findViewById(R.id.payDD)
        tvCycleYY = findViewById(R.id.tvCycleYY)
        tvCycleMM = findViewById(R.id.tvCycleMM)
        tvCycleDD = findViewById(R.id.tvCycleDD)
        notiYY = findViewById(R.id.notiYY)
        notiMM = findViewById(R.id.notiMM)
        notiDD = findViewById(R.id.notiDD)
        tvmemo = findViewById(R.id.tvmemo)
        btnback = findViewById(R.id.btnback)

        //입력 했던 구독 정보 출력하기
        val intent = intent
        var str_name = intent.getStringExtra("intent_name").toString()

        //btnback 버튼 클릭 시 메인으로(MainActivity)으로 이동
        btnback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //DB연결
        dbManager = DBManager(this, "subaddDB", null, 1)
        //DB읽기
        sqlitedb = dbManager.readableDatabase

        //DB 커서
        var cursor: Cursor
        cursor = sqlitedb.rawQuery("SELECT * FROM subaddDB WHERE subName = '" + str_name + "';", null)

        while(cursor.moveToNext()){
            //var str_name = cursor.getString(cursor.getColumnIndex("subName")).toString()
            var str_payment = cursor.getInt(cursor.getColumnIndex("payment"))
            var str_category = cursor.getString(cursor.getColumnIndex("subCategory")).toString()
            var str_payYY = cursor.getInt(cursor.getColumnIndex("payDateYY"))
            var str_payMM = cursor.getInt(cursor.getColumnIndex("payDateMM"))
            var str_payDD = cursor.getInt(cursor.getColumnIndex("payDateDD"))
            var str_CycleYY = cursor.getInt(cursor.getColumnIndex("payCycleYY"))
            var str_CycleMM = cursor.getInt(cursor.getColumnIndex("payCycleMM"))
            var str_CycleDD = cursor.getInt(cursor.getColumnIndex("payCycleDD"))
            var str_notiYY = cursor.getInt(cursor.getColumnIndex("notiYY"))
            var str_notiMM = cursor.getInt(cursor.getColumnIndex("notiMM"))
            var str_notiDD = cursor.getInt(cursor.getColumnIndex("notiDD"))
            var str_memo = cursor.getString(cursor.getColumnIndex("memo")).toString()

            tvName.text = str_name
            tvPayment.text =str_payment.toString()
            tvCategory.text=str_category
            payYY.text =str_payYY.toString()
            payMM.text =str_payMM.toString()
            payDD.text =str_payDD.toString()
            tvCycleYY.text =str_CycleYY.toString()
            tvCycleMM.text =str_CycleMM.toString()
            tvCycleDD.text =str_CycleDD.toString()
            notiYY.text =str_notiYY.toString()
            notiMM.text =str_notiMM.toString()
            notiDD.text =str_notiDD.toString()
            tvmemo.text =str_memo

        }

        //커서 및 DB 닫기
        cursor.close()
        sqlitedb.close()
        dbManager.close()

        //수정하기 버튼을 눌렀을 때 SubUpdate 액티비티로 이동
        btnUpdate.setOnClickListener {
            //SubUpdate 액티비티로 이동
            val intent = Intent(this, SubUpdate::class.java)
            intent.putExtra("intent_name", str_name)
            startActivity(intent)
        }

        //삭제하기 버튼을 눌렀을 때
        btnDelete.setOnClickListener {
            dbManager = DBManager(this, "subaddDB", null, 1)
            sqlitedb = dbManager.readableDatabase
            sqlitedb.execSQL("DELETE FROM subaddDB WHERE subName = '" + str_name + "';")
            sqlitedb.close()
            dbManager.close()

            //삭제 후 메인 액티비티로 이동
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            //토스트 메시지 출력
            Toast.makeText(this, "삭제 되었습니다.", Toast.LENGTH_SHORT).show()
        }

    }
}