package com.example.link

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SubchartActivity : AppCompatActivity() {


    lateinit var btn_show_main2: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subchart)

        //변수와 위젯을 연동
       btn_show_main2 = findViewById(R.id.btn_show_main2)

        //버튼 클릭 시 메인화면으로 이동
       btn_show_main2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)}


        /*------리사이클러뷰 관련 코드-------*/

        //xml파일 속 리사이클러뷰 위젯을 변수 선언 및 위젯 연결
        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)

        //리사이클러뷰에 내가 만들어놓은 어댑터 연결
        val mAdapter = RcviewAdapter(this, subDataList)
        recycler_view.adapter = mAdapter

        //리사이클러뷰에 LinearLayoutManager(아이템뷰를 배치시키는 역할) 객체 지정.
        val lm = LinearLayoutManager(this)
        recycler_view.layoutManager = lm

        recycler_view.setHasFixedSize(true) //사이즈 고정
    }

    //리사이클러뷰에 띄울 구독 리스트들
    var subDataList = arrayListOf<SubData>(
        SubData("naverplus_logo", "네이버 플러스", "#쇼핑"),
        SubData("netflix_logo", "넷플릭스", "#ott"),
        SubData("notion_logo", "노션", "#프로그램"),
        SubData("nintendoswitch_logo", "닌텐도 스위치 온라인", "#게임"),
        SubData("dropbax_logo", "드롭박스", "#프로그램"),
        SubData("rocketwow_logo", "로켓와우", "#쇼핑"),
        SubData("ridi_logo", "리디 설렉트", "#독서"),
        SubData("melon_logo", "멜론", "#음악"),
        SubData("millie_logo", "밀리의 서재", "#독서"),
        SubData("vibe_logo", "바이브", "#음악"),
        SubData("bugs_logo", "벅스", "#음악"),
        SubData("smileclub_logo", "스마일클럽", "#쇼핑"),
        SubData("spotify_logo", "스포티파이", "#음악"),
        SubData("slack_logo", "슬랙", "#프로그램"),
        SubData("seezn_logo", "시즌", "#ott"),
        SubData("socar_logo", "쏘카", "#기타"),
        SubData("afreecatv_logo", "아프리카TV", "#게임"),
        SubData("applemusic_logo", "애플뮤직", "#음악"),
        SubData("adobecloud_logo", "어도비 클라우드", "#프로그램"),
        SubData("evernote_logo", "에버노트", "#프로그램"),
        SubData("yes24bookclub_logo", "예스24 북클럽", "#독서"),
        SubData("watcha_logo", "왓챠", "#ott"),
        SubData("wavve_logo", "웨이브", "#ott"),
        SubData("welaaa_logo", "윌라", "#도서"),
        SubData("youtube_logo", "유튜브 프리미엄", "#ott"),
        SubData("genie_logo", "지니뮤직", "#음악"),
        SubData("trive_logo", "트라이브", "#기타"),
        SubData("twitch_logo", "트위치", "#게임"),
        SubData("tving_logo", "티빙", "#ott"),
        SubData("podbbang_logo", "팟빵", "#학습"),
        SubData("playstation_logo", "플레이스테이션 플러스", "#게임"),
        SubData("flo_logo", "플로", "#음악"),
    )

}