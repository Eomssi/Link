package com.example.link

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

/*-------- 로딩화면 ---------*/
class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        //핸들러 생성
        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable {
            //로딩화면에서 메인화면으로 가도록 하는 인텐트 생성
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        //핸들러를 이용해 3초 뒤 화면 전환
        handler.postDelayed(runnable,3000)
    }
}