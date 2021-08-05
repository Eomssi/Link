package com.example.link

import android.content.Intent
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.widget.Toolbar
import de.hdodenhof.circleimageview.CircleImageView

class SubAdd : AppCompatActivity() {

    //DB 변수 선언
    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase

    //위젯 변수 선언
    lateinit var btnAdd: Button
    lateinit var subLogo: CircleImageView
    lateinit var edtName: EditText
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
    lateinit var tlbname: TextView
    lateinit var btnback: ImageButton

    //DB에서 받는 정보 변수
    lateinit var str_name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_add)

        //위젯 변수 연결
        btnAdd = findViewById(R.id.btnAdd)
        subLogo = findViewById(R.id.subLogo)
        edtName = findViewById(R.id.edtName)
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
        tlbname = findViewById(R.id.tlbname)
        btnback = findViewById(R.id.btnback)

        //서비스 소개 액티비티에서 전달 된 데이터 받음
        val intent = intent
        str_name = intent.getStringExtra("intent_name").toString()

        //btnback 버튼 클릭 시 구독 리스트(SubchartActivity)으로 이동
        btnback.setOnClickListener {
            val intent = Intent(this, SubchartActivity::class.java)
            startActivity(intent)
        }

        //상단 텍스트뷰에 구독리스트에서 전달받은 구독 서비스 이름 출력
        tlbname.text = str_name

        //subaddDB DB연결
        dbManager = DBManager(this, "subaddDB", null, 1)

        when{
            str_name == "네이버 플러스" -> {
                subLogo.setImageResource(R.drawable.naverplus_logo)
            }
            str_name == "넷플릭스" -> {
                subLogo.setImageResource(R.drawable.netflix_logo)
            }
            str_name == "노션" -> {
                subLogo.setImageResource(R.drawable.notion_logo)
            }
            str_name == "닌텐도 스위치 온라인" -> {
                subLogo.setImageResource(R.drawable.nintendoswitch_logo)
            }
            str_name == "드롭박스" -> {
                subLogo.setImageResource(R.drawable.dropbox_logo)
            }
            str_name == "로켓와우" -> {
                subLogo.setImageResource(R.drawable.rocketwow_logo)
            }
            str_name == "리디 셀렉트" -> {
                subLogo.setImageResource(R.drawable.ridi_logo)
            }
            str_name == "멜론" -> {
                subLogo.setImageResource(R.drawable.melon_logo)
            }
            str_name == "밀리의 서재" -> {
                subLogo.setImageResource(R.drawable.millie_logo)
            }
            str_name == "바이브" -> {
                subLogo.setImageResource(R.drawable.vibe_logo)
            }
            str_name == "벅스" -> {
                subLogo.setImageResource(R.drawable.bugs_logo)
            }
            str_name == "스마일클럽" -> {
                subLogo.setImageResource(R.drawable.smileclub_logo)
            }
            str_name == "스포티파이" -> {
                subLogo.setImageResource(R.drawable.spotify_logo)
            }
            str_name == "슬랙" -> {
                subLogo.setImageResource(R.drawable.slack_logo)
            }
            str_name == "시즌" -> {
                subLogo.setImageResource(R.drawable.seezn_logo)
            }
            str_name == "쏘카" -> {
                subLogo.setImageResource(R.drawable.socar_logo)
            }
            str_name == "아프리카 TV" -> {
                subLogo.setImageResource(R.drawable.afreecatv_logo)
            }
            str_name == "애플뮤직" -> {
                subLogo.setImageResource(R.drawable.applemusic_logo)
            }
            str_name == "어도비 클라우드" -> {
                subLogo.setImageResource(R.drawable.adobecloud_logo)
            }
            str_name == "에버노트" -> {
                subLogo.setImageResource(R.drawable.evernote_logo)
            }
            str_name == "예스24 북클럽" -> {
                subLogo.setImageResource(R.drawable.yes24bookclub_logo)
            }
            str_name == "왓챠" -> {
                subLogo.setImageResource(R.drawable.watcha_logo)
            }
            str_name == "웨이브" -> {
                subLogo.setImageResource(R.drawable.wavve_logo)
            }
            str_name == "윌라" -> {
                subLogo.setImageResource(R.drawable.welaaa_logo)
            }
            str_name == "유튜브 프리미엄" -> {
                subLogo.setImageResource(R.drawable.youtube_logo)
            }
            str_name == "지니뮤직" -> {
                subLogo.setImageResource(R.drawable.genie_logo)
            }
            str_name == "트라이브" -> {
                subLogo.setImageResource(R.drawable.trive_logo)
            }
            str_name == "트위치" -> {
                subLogo.setImageResource(R.drawable.twitch_logo)
            }
            str_name == "티빙" -> {
                subLogo.setImageResource(R.drawable.tving_logo)
            }
            str_name == "팟빵" -> {
                subLogo.setImageResource(R.drawable.podbbang_logo)
            }
            str_name == "플레이스테이션 플러스" -> {
                subLogo.setImageResource(R.drawable.playstation_logo)
            }
            str_name == "플로" -> {
                subLogo.setImageResource(R.drawable.flo_logo)
            }
            str_name == "직접 입력" -> {
                subLogo.setImageResource(R.drawable.ic_basicimage)
            }
        }

        //추가하기 버튼을 눌렀을 때
        btnAdd.setOnClickListener {
            //브랜드 이름
            var str_name: String = edtName.text.toString()
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
            //알림
            var str_notiYY: String = notiYY.selectedItem.toString()
            var str_notiMM: String = notiMM.selectedItem.toString()
            var str_notiDD: String = notiDD.selectedItem.toString()
            //메모
            var str_memo: String = edtmemo.text.toString()

            try {
                //DB에 쓰기, subaddDB에 내용 저장하기, DB 닫기
                sqlitedb = dbManager.writableDatabase
                sqlitedb.execSQL("INSERT INTO subaddDB VALUES ('"+ str_name+ "', '"+ str_payment+ "', '"+ str_category+ "', '"+ str_payYY+ "', '"+ str_payMM+ "', '"+ str_payDD+ "', '"+ str_payCycleYY+ "', '"+ str_payCycleMM+ "', '"+ str_payCycleDD+ "', '"+ str_notiYY+ "', '"+ str_notiMM+ "', '"+ str_notiDD+ "', '"+ str_memo+ "');")
                sqlitedb.close()
            }catch (e: SQLiteConstraintException){
                //토스트 메시지 출력
                Toast.makeText(this, "이미 존재하는 구독서비스입니다.", Toast.LENGTH_SHORT).show()
            }


            //저장한 내용의 브랜드 이름을 메인 액티비티로 전달
            val intent = Intent(this, MainActivity::class.java)
            //intent.putExtra("intent_name", str_name)
            startActivity(intent)

            //토스트 메시지 출력
            Toast.makeText(this, "저장 되었습니다.", Toast.LENGTH_SHORT).show()

        }



    }
}