package com.example.link

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import de.hdodenhof.circleimageview.CircleImageView

class SubUpdate : AppCompatActivity() {
    //DB 변수 선언
    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase

    //위젯 변수 선언
    lateinit var btnback: ImageButton
    lateinit var btnAdd: Button
    lateinit var tvName: TextView
    lateinit var edtPayment: EditText
    lateinit var edtCategory: EditText
    lateinit var payYY: Spinner
    lateinit var payMM: Spinner
    lateinit var payDD: Spinner
    lateinit var cycleYY: Spinner
    lateinit var cycleMM: Spinner
    lateinit var cycleDD: Spinner
    lateinit var notiYY: Spinner
    lateinit var notiMM: Spinner
    lateinit var notiDD: Spinner
    lateinit var edtmemo: EditText

    //DB에서 받는 데이터 변수(구독 서비스 이름)
    lateinit var str_name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_update)

        //위젯 변수 연결
        btnback = findViewById(R.id.btnback)
        btnAdd = findViewById(R.id.btnAdd)
        tvName = findViewById(R.id.tvName)
        edtPayment = findViewById(R.id.edtPayment)
        edtCategory = findViewById(R.id.edtCategory)
        payYY = findViewById(R.id.payYY)
        payMM = findViewById(R.id.payMM)
        payDD = findViewById(R.id.payDD)
        cycleYY = findViewById(R.id.cycleYY)
        cycleMM = findViewById(R.id.cycleMM)
        cycleDD = findViewById(R.id.cycleDD)
        notiYY = findViewById(R.id.notiYY)
        notiMM = findViewById(R.id.notiMM)
        notiDD = findViewById(R.id.notiDD)
        edtmemo = findViewById(R.id.edtmemo)

        //subaddDB연결
        dbManager = DBManager(this, "subaddDB", null, 1)

        //SubDetailDelete(구독 상세 정보)액티비티에서 전달 된 데이터 받음
        val intent = intent
        str_name = intent.getStringExtra("intent_name").toString()

        //btnback 버튼 클릭 시 해당 SubDetailDelete(구독 상세 정보)액티비티로 이동
        btnback.setOnClickListener {
            val intent = Intent(this, SubDetailDelete::class.java)
            intent.putExtra("intent_name", str_name)
            startActivity(intent)
        }

        //edtName칸에 구독 내역에서 넘겨받은 이름 띄우기
        tvName.text = str_name

        //btnAdd(수정완료) 버튼을 눌렀을 때
        btnAdd.setOnClickListener {
            //브랜드 이름
            str_name = tvName.text.toString()
            //최종 결제 금액
            var str_payment: String = edtPayment.text.toString()
            //카테고리
            var str_category: String = edtCategory.text.toString()
            //첫 결제일
            var str_payYY: String = payYY.selectedItem.toString()
            var str_payMM: String = payMM.selectedItem.toString()
            var str_payDD: String = payDD.selectedItem.toString()
            //결제 주기
            var str_payCycleYY: String = cycleYY.selectedItem.toString()
            var str_payCycleMM: String = cycleMM.selectedItem.toString()
            var str_payCycleDD: String = cycleDD.selectedItem.toString()
            //다음 결제일
            var str_notiYY: String = notiYY.selectedItem.toString()
            var str_notiMM: String = notiMM.selectedItem.toString()
            var str_notiDD: String = notiDD.selectedItem.toString()
            //메모
            var str_memo: String = edtmemo.text.toString()

            //DB에 쓰기, subaddDB에 내용 업데이트, DB 닫기
            try {
                sqlitedb = dbManager.writableDatabase
                sqlitedb.execSQL("UPDATE subaddDB SET payment = "+ str_payment+ " WHERE subName = '"+ str_name+ "';")
                sqlitedb.execSQL("UPDATE subaddDB SET subCategory = '"+ str_category+ "' WHERE subName = '"+ str_name+ "';")
                sqlitedb.execSQL("UPDATE subaddDB SET payDateYY = "+ str_payYY+ " WHERE subName = '"+ str_name+ "';")
                sqlitedb.execSQL("UPDATE subaddDB SET payDateMM = "+ str_payMM+ " WHERE subName = '"+ str_name+ "';")
                sqlitedb.execSQL("UPDATE subaddDB SET payDateDD = "+ str_payDD+ " WHERE subName = '"+ str_name+ "';")
                sqlitedb.execSQL("UPDATE subaddDB SET payCycleYY = "+ str_payCycleYY+ " WHERE subName = '"+ str_name+ "';")
                sqlitedb.execSQL("UPDATE subaddDB SET payCycleMM = "+ str_payCycleMM+ " WHERE subName = '"+ str_name+ "';")
                sqlitedb.execSQL("UPDATE subaddDB SET payCycleDD = "+ str_payCycleDD+ " WHERE subName = '"+ str_name+ "';")
                sqlitedb.execSQL("UPDATE subaddDB SET notiYY = "+ str_notiYY+ " WHERE subName = '"+ str_name+ "';")
                sqlitedb.execSQL("UPDATE subaddDB SET notiMM = "+ str_notiMM+ " WHERE subName = '"+ str_name+ "';")
                sqlitedb.execSQL("UPDATE subaddDB SET notiDD = "+ str_notiDD+ " WHERE subName = '"+ str_name+ "';")
                sqlitedb.execSQL("UPDATE subaddDB SET memo = '"+ str_memo+ "' WHERE subName = '"+ str_name+ "';")
                sqlitedb.close()
            }catch (e: SQLiteException){
                //토스트 메시지 출력
                Toast.makeText(this, "수정 실패! 빈칸을 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }

            //저장한 내용의 구독 서비스 이름을 MainActivity 액티비티로 전달하면서 이동
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("intent_name", str_name)
            startActivity(intent)

            //토스트 메시지 출력
            Toast.makeText(this, "수정 되었습니다.", Toast.LENGTH_SHORT).show()

        }

    }
}

