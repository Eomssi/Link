package com.example.link

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {

    //xml파일에서 사용한 위젯을 위한 변수 선언
    lateinit var btn_show_subchart: ImageButton
    lateinit var btn_show_mndetail: ImageButton
    lateinit var txt_month: TextView
    lateinit var txt_MMdd: TextView
    lateinit var mRecycler_view: RecyclerView
    lateinit var txt_total: TextView

    //DB 변수 선언
    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase

    //총 결제 금액 변수
    var total_payment: Int = 0


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //위에서 선언한 변수를 위젯과 연동
        btn_show_subchart = findViewById<ImageButton>(R.id.btn_show_subchart)
        btn_show_mndetail = findViewById<ImageButton>(R.id.btn_show_mndetail)
        txt_month = findViewById<TextView>(R.id.txt_month)
        txt_MMdd = findViewById<TextView>(R.id.txt_MMdd)
        txt_total = findViewById(R.id.txt_total)

        //DB 연동
        dbManager = DBManager(this, "subaddDB", null, 1)
        sqlitedb = dbManager.readableDatabase   //읽기

        //버튼 클릭 시 구독서비스등록 화면으로 전환
        btn_show_subchart.setOnClickListener {
            val intent = Intent(this, SubchartActivity::class.java)
            startActivity(intent)
        }

        //버튼 클릭 시 예산분석 화면으로 전환
        btn_show_mndetail.setOnClickListener {
            val intent = Intent(this, MoneydetailActivity::class.java)
            //intent.putExtra("intent_total_payment", total_payment)
            startActivity(intent)
        }

        val current = LocalDateTime.now()
        val mFormatter = DateTimeFormatter.ofPattern("M", Locale("ko", "kr"))
        val mFormatted = current.format(mFormatter)

        val mmddFormatter = DateTimeFormatter.ofPattern("MM/dd", Locale("ko", "kr"))
        val mmddFormatted = current.format(mmddFormatter)

        txt_month.setText(mFormatted)
        txt_MMdd.setText(mmddFormatted)


        /*------리사이클러뷰 관련 코드-------*/

        //xml파일 속 리사이클러뷰 위젯을 변수 선언 및 위젯 연결
        mRecycler_view = findViewById<RecyclerView>(R.id.rcView_main)

        //리사이클러뷰에 내가 만들어놓은 어댑터 연결
        val mAdapter = MainAdapter(this, mainSubDataList) {MainSubData ->

            var str_name = MainSubData.subTitle
            val intent = Intent(this, SubDetailDelete::class.java)
            intent.putExtra("intent_name", str_name)
            startActivity(intent)
        }
        mRecycler_view.adapter = mAdapter

        //리사이클러뷰에 LinearLayoutManager(아이템뷰를 배치시키는 역할) 객체 지정.
        val lm = LinearLayoutManager(this)
        mRecycler_view.layoutManager = lm

        mRecycler_view.setHasFixedSize(true) //사이즈 고정



        //DB 커서 선언
        var cursor: Cursor

        //subaddDB의 payment 데이터 총합 조회, txt_total 창에 띄우기
        cursor = sqlitedb.rawQuery("SELECT SUM(payment) FROM subaddDB;", null)
        while(cursor.moveToNext()) {
            total_payment = cursor.getInt(cursor.getColumnIndex("SUM(payment)"))
            txt_total.text = total_payment.toString()
        }

        //subaddDB 컬럼 모두 조회
        cursor = sqlitedb.rawQuery("SELECT * FROM subaddDB;", null)
        while(cursor.moveToNext()) {
            var str_name = cursor.getString(cursor.getColumnIndex("subName")).toString()
            var payment = cursor.getInt(cursor.getColumnIndex("payment"))
            var dateMM =  cursor.getInt(cursor.getColumnIndex("notiMM"))
            var datedd = cursor.getInt(cursor.getColumnIndex("notiDD"))

            //로고 설정, str_name에 따라 로고 이미지 변경
            var logo: String
            when{
                str_name == "네이버 플러스" -> {
                    logo = "naverplus_logo"
                }
                str_name == "넷플릭스" -> {
                    logo = "netflix_logo"
                }
                str_name == "노션" -> {
                    logo = "notion_logo"
                }
                str_name == "닌텐도 스위치 온라인" -> {
                    logo = "nintendoswich_logo"
                }
                str_name == "드롭박스" -> {
                    logo = "dropbox_logo"
                }
                str_name == "로켓와우" -> {
                    logo = "rocketwow_logo"
                }
                str_name == "리디 셀렉트" -> {
                    logo = "ridi_logo"
                }
                str_name == "멜론" -> {
                    logo = "melon_logo"
                }
                str_name == "밀리의 서재" -> {
                    logo = "millie_logo"
                }
                str_name == "바이브" -> {
                    logo = "vibe_logo"
                }
                str_name == "벅스" -> {
                    logo = "bugs_logo"
                }
                str_name == "스마일클럽" -> {
                    logo = "smileclub_logo"
                }
                str_name == "스포티파이" -> {
                    logo = "spotify_logo"
                }
                str_name == "슬랙" -> {
                    logo = "slack_logo"
                }
                str_name == "시즌" -> {
                    logo = "seezn_logo"
                }
                str_name == "쏘카" -> {
                    logo = "socar_logo"
                }
                str_name == "아프리카 TV" -> {
                    logo = "afreecatv_logo"
                }
                str_name == "애플뮤직" -> {
                    logo = "applemusic_logo"
                }
                str_name == "어도비 클라우드" -> {
                    logo = "adobecloud_logo"
                }
                str_name == "에버노트" -> {
                    logo = "evernote_logo"
                }
                str_name == "예스24 북클럽" -> {
                    logo = "yes24bookclub_logo"
                }
                str_name == "왓챠" -> {
                    logo = "watcha_logo"
                }
                str_name == "웨이브" -> {
                    logo = "wavve_logo"
                }
                str_name == "윌라" -> {
                    logo = "welaaa_logo"
                }
                str_name == "유튜브 프리미엄" -> {
                    logo = "youtube_logo"
                }
                str_name == "지니뮤직" -> {
                    logo = "genie_logo"
                }
                str_name == "트라이브" -> {
                    logo = "trive_logo"
                }
                str_name == "트위치" -> {
                    logo = "twitch_logo"
                }
                str_name == "티빙" -> {
                    logo = "tving_logo"
                }
                str_name == "팟빵" -> {
                    logo = "podbbang_logo"
                }
                str_name == "플레이스테이션 플러스" -> {
                    logo = "playstation_logo"
                }
                str_name == "플로" -> {
                    logo = "flo_logo"
                }
                else -> {
                    logo = "ic_basicimage"
                }
            }

            //subaddDB에서 받은 내용 mainSubDataList 배열에 추가
            var mSubData = MainSubData(logo, str_name, payment, dateMM, datedd)
            mainSubDataList.add(mSubData)
            //어댑터에 초기화 요청
            mAdapter.notifyDataSetChanged()
        }

        //커서 및 DB 닫기
        cursor.close()
        sqlitedb.close()
        dbManager.close()


    }

    //mainSubData가 들어가는 리스트
    var mainSubDataList = arrayListOf<MainSubData>(

    )
}