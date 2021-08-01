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
        //subiffoDB, subaddDB 테이블 생성
        db!!.execSQL("CREATE TABLE subinfoDB (subName TEXT PRIMARY KEY, subLink TEXT, subCategory TEXT, subIntroduction TEXT, subPayment TEXT)")
        db!!.execSQL("CREATE TABLE subaddDB (subName TEXT PRIMARY KEY, payment INTEGER, subCategory TEXT, payDateYY INTEGER, payDateMM INTEGER, payDateDD INTEGER, payCycleYY INTEGER, payCycleMM INTEGER, payCycleDD INTEGER, notiYY INTEGER, notiMM INTEGER, notiDD INTEGER, memo TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}