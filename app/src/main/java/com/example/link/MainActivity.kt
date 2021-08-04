package com.example.link

import android.content.Intent
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


        /*------리사이클러뷰 관련 코드-------*/

        //xml파일 속 리사이클러뷰 위젯을 변수 선언 및 위젯 연결
        mRecycler_view = findViewById<RecyclerView>(R.id.rcView_main)

        //리사이클러뷰에 내가 만들어놓은 어댑터 연결
        val mAdapter = MainAdapter(this, mainSubDataList) {MainSubData ->
            /*var str_name = intent.getStringExtra("title_str").toString()
             val intent = Intent(this, SubInfo::class.java)
             intent.putExtra("intent_name", str_name)
             startActivity(intent)*/
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

    }

    var mainSubDataList = arrayListOf<MainSubData>(
        MainSubData("naverplus_logo", "네이버 플러스", 9500),
        MainSubData("netflix_logo", "넷플릭스", 3250),
        MainSubData("notion_logo", "노션", 5440),
        MainSubData("nintendoswitch_logo", "닌텐도 스위치 온라인", 9900)

    )
}