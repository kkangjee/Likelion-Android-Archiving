package com.smu.sangmyung.likelionandroidarchiving

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.item_list.*


class RecordActivity : AppCompatActivity() {
    var RecordList = arrayListOf(
        RecordList("kakao_1","심슨"),
        RecordList("kakao_2","심슨"),
        RecordList("kakao_3","심슨"),
        RecordList("kakao_4","심슨"),
        RecordList("kakao_5","심슨")

    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_list)
        
        val mAdapter = RecordRvAdapter(this,RecordList)//this=context
        recyclerView.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)//내용물의 크기를 고정해주겠다.
    }

}