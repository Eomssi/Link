package com.example.link

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class SubInfo : AppCompatActivity() {

    //DB 변수 선언
    lateinit var dbManager: DBManager
    lateinit var sqlitedb: SQLiteDatabase

    //위젯 변수 선언
    lateinit var subname: TextView
    lateinit var textLink: TextView
    lateinit var textCategory: TextView
    lateinit var textIntro: TextView
    lateinit var textPayment: TextView
    lateinit var subLogo: CircleImageView
    lateinit var subImage1: ImageView
    lateinit var subImage2: ImageView

    lateinit var btnSubadd: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub_info)

        //화면 위 버튼 연결
        btnSubadd = findViewById(R.id.btnSubadd)

        //화면 위젯 연결
        subLogo = findViewById(R.id.subLogo)
        subname = findViewById(R.id.subname)
        textLink = findViewById(R.id.textLink)
        textCategory = findViewById(R.id.textCategory)
        textIntro = findViewById(R.id.textIntro)
        textPayment = findViewById(R.id.textPayment)
        subImage1 = findViewById(R.id.subImage1)
        subImage2 = findViewById(R.id.subImage2)

        //DB 연결
        dbManager = DBManager(this, "subinfoDB", null, 1)
        sqlitedb = dbManager.readableDatabase       //읽기

        //구독 서비스 액티비티에서 전달 된 데이터 받음
        val intent = intent
        var str_name = intent.getStringExtra("intent_name").toString()  //str_name: 구독리스트에서 클릭한 브랜드 이름

        //서비스 추가 버튼 클릭 시 SubAdd 액티비티로 이동
        btnSubadd.setOnClickListener {
            var intent = Intent(this, SubAdd::class.java)
            intent.putExtra("intent_name",str_name)
            startActivity(intent)
        }

        //구독 서비스 액티비티에서 받은 데이터에 따른 이미지 출력(로고, 상세 이미지)
        when{
            str_name == "네이버 플러스" -> {
                subLogo.setImageResource(R.drawable.naverplus_logo)
                subImage1.setImageResource(R.drawable.naverplus1)
                subImage2.setImageResource(R.drawable.naverplus2)
            }

            str_name == "넷플릭스" -> {
                subLogo.setImageResource(R.drawable.netflix_logo)
                subImage1.setImageResource(R.drawable.netflix1)
                subImage2.setImageResource(R.drawable.netflix2)
            }

            str_name == "노션" -> {
                subLogo.setImageResource(R.drawable.notion_logo)
                subImage1.setImageResource(R.drawable.notion1)
                subImage2.setImageResource(R.drawable.notion2)
            }

            str_name == "닌텐도 스위치 온라인" -> {
                subLogo.setImageResource(R.drawable.nintendoswitch_logo)
                subImage1.setImageResource(R.drawable.nintendoswitch1)
                subImage2.setImageResource(R.drawable.nintendoswitch2)
            }

            str_name == "드롭박스" -> {
                subLogo.setImageResource(R.drawable.dropbox_logo)
                subImage1.setImageResource(R.drawable.dropbox1)
                subImage2.setImageResource(R.drawable.dropbox2)
            }

            str_name == "로켓와우" -> {
                subLogo.setImageResource(R.drawable.rocketwow_logo)
                subImage1.setImageResource(R.drawable.rocketwow1)
                subImage2.setImageResource(R.drawable.rocketwow2)
            }
            str_name == "리디 셀렉트" -> {
                subLogo.setImageResource(R.drawable.ridi_logo)
                subImage1.setImageResource(R.drawable.ridi1)
                subImage2.setImageResource(R.drawable.ridi2)
            }
            str_name == "멜론" -> {
                subLogo.setImageResource(R.drawable.melon_logo)
                subImage1.setImageResource(R.drawable.melon1)
                subImage2.setImageResource(R.drawable.melon2)
            }
            str_name == "밀리의 서재" -> {
                subLogo.setImageResource(R.drawable.millie_logo)
                subImage1.setImageResource(R.drawable.millie1)
                subImage2.setImageResource(R.drawable.millie2)
            }
            str_name == "바이브" -> {
                subLogo.setImageResource(R.drawable.vibe_logo)
                subImage1.setImageResource(R.drawable.vibe1)
                subImage2.setImageResource(R.drawable.vibe2)
            }
            str_name == "벅스" -> {
                subLogo.setImageResource(R.drawable.bugs_logo)
                subImage1.setImageResource(R.drawable.bugs1)
                subImage2.setImageResource(R.drawable.bugs2)
            }
            str_name == "스마일클럽" -> {
                subLogo.setImageResource(R.drawable.smileclub_logo)
                subImage1.setImageResource(R.drawable.smileclub1)
                subImage2.setImageResource(R.drawable.smileclub2)
            }
            str_name == "스포티파이" -> {
                subLogo.setImageResource(R.drawable.spotify_logo)
                subImage1.setImageResource(R.drawable.spotify1)
                subImage2.setImageResource(R.drawable.spotify2)
            }
            str_name == "슬랙" -> {
                subLogo.setImageResource(R.drawable.slack_logo)
                subImage1.setImageResource(R.drawable.slack1)
                subImage2.setImageResource(R.drawable.slack2)
            }
            str_name == "시즌" -> {
                subLogo.setImageResource(R.drawable.seezn_logo)
                subImage1.setImageResource(R.drawable.seezn1)
                subImage2.setImageResource(R.drawable.seezn2)
            }
            str_name == "쏘카" -> {
                subLogo.setImageResource(R.drawable.socar_logo)
                subImage1.setImageResource(R.drawable.socar1)
                subImage2.setImageResource(R.drawable.socar2)
            }
            str_name == "아프리카 TV" -> {
                subLogo.setImageResource(R.drawable.afreecatv_logo)
                subImage1.setImageResource(R.drawable.afreecatv1)
                subImage2.setImageResource(R.drawable.afreecatv2)
            }
            str_name == "애플뮤직" -> {
                subLogo.setImageResource(R.drawable.applemusic_logo)
                subImage1.setImageResource(R.drawable.applemusic1)
                subImage2.setImageResource(R.drawable.applemusic2)
            }
            str_name == "어도비 클라우드" -> {
                subLogo.setImageResource(R.drawable.adobecloud_logo)
                subImage1.setImageResource(R.drawable.adobecloud1)
                subImage2.setImageResource(R.drawable.adobecloud2)
            }
            str_name == "에버노트" -> {
                subLogo.setImageResource(R.drawable.evernote_logo)
                subImage1.setImageResource(R.drawable.evernote1)
                subImage2.setImageResource(R.drawable.evernote2)
            }
            str_name == "예스24 북클럽" -> {
                subLogo.setImageResource(R.drawable.yes24bookclub_logo)
                subImage1.setImageResource(R.drawable.yes24bookclub1)
                subImage2.setImageResource(R.drawable.yes24bookclub2)
            }
            str_name == "왓챠" -> {
                subLogo.setImageResource(R.drawable.watcha_logo)
                subImage1.setImageResource(R.drawable.watcha1)
                subImage2.setImageResource(R.drawable.watcha2)
            }
            str_name == "웨이브" -> {
                subLogo.setImageResource(R.drawable.wavve_logo)
                subImage1.setImageResource(R.drawable.wavve1)
                subImage2.setImageResource(R.drawable.wavve2)
            }
            str_name == "윌라" -> {
                subLogo.setImageResource(R.drawable.welaaa_logo)
                subImage1.setImageResource(R.drawable.welaaa1)
                subImage2.setImageResource(R.drawable.welaaa2)
            }
            str_name == "유튜브 프리미엄" -> {
                subLogo.setImageResource(R.drawable.youtube_logo)
                subImage1.setImageResource(R.drawable.youtube1)
                subImage2.setImageResource(R.drawable.youtube2)
            }
            str_name == "지니뮤직" -> {
                subLogo.setImageResource(R.drawable.genie_logo)
                subImage1.setImageResource(R.drawable.genie1)
                subImage2.setImageResource(R.drawable.genie2)
            }
            str_name == "트라이브" -> {
                subLogo.setImageResource(R.drawable.trive_logo)
                subImage1.setImageResource(R.drawable.trive1)
                subImage2.setImageResource(R.drawable.trive2)
            }
            str_name == "트위치" -> {
                subLogo.setImageResource(R.drawable.twitch_logo)
                subImage1.setImageResource(R.drawable.twitch1)
                subImage2.setImageResource(R.drawable.twitch2)
            }
            str_name == "티빙" -> {
                subLogo.setImageResource(R.drawable.tving_logo)
                subImage1.setImageResource(R.drawable.tving1)
                subImage2.setImageResource(R.drawable.tving2)
            }
            str_name == "팟빵" -> {
                subLogo.setImageResource(R.drawable.podbbang_logo)
                subImage1.setImageResource(R.drawable.podbbang1)
                subImage2.setImageResource(R.drawable.podbbang2)
            }
            str_name == "플레이스테이션 플러스" -> {
                subLogo.setImageResource(R.drawable.playstation_logo)
                subImage1.setImageResource(R.drawable.playstation1)
                subImage2.setImageResource(R.drawable.playstation2)
            }
            str_name == "플로" -> {
                subLogo.setImageResource(R.drawable.flo_logo)
                subImage1.setImageResource(R.drawable.flo1)
                subImage2.setImageResource(R.drawable.flo2)
            }

        }

        //DB 커서
        var cursor: Cursor
        cursor = sqlitedb.rawQuery("SELECT * FROM subinfoDB WHERE subName = '" + str_name + "';", null)

        while(cursor.moveToNext()){
            var str_link = cursor.getString(cursor.getColumnIndex("subLink")).toString()
            var str_category = cursor.getString(cursor.getColumnIndex("subCategory")).toString()
            var str_intro = cursor.getString(cursor.getColumnIndex("subIntroduction")).toString()
            var str_payment = cursor.getString(cursor.getColumnIndex("subPayment")).toString()

            //위젯에 연결
            subname.text = str_name
            textLink.text = str_link
            textCategory.text = str_category
            textIntro.text = str_intro
            textPayment.text = str_payment
        }

        //커서 및 DB 닫기
        cursor.close()
        sqlitedb.close()
        dbManager.close()







    }




}