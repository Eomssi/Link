package com.example.link

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBManager(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        //subaddDB 테이블 생성, 구독 추가하기 및 구독서비스 관리에 사용
        db!!.execSQL("CREATE TABLE subaddDB (subName TEXT PRIMARY KEY, payment INTEGER, subCategory TEXT, payDateYY INTEGER, payDateMM INTEGER, payDateDD INTEGER, payCycleYY INTEGER, payCycleMM INTEGER, payCycleDD INTEGER, notiYY INTEGER, notiMM INTEGER, notiDD INTEGER, memo TEXT);")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}