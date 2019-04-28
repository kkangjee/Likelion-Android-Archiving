package com.smu.sangmyung.likelionandroidarchiving

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup

class MainAdapter(fm:FragmentManager): FragmentStatePagerAdapter(fm) {//연결해줌
override fun getItem(p0: Int): Fragment {
    return when(p0){//p는 포지션
        0->AFregment()
        1->BFragment()
        2->CFragment()

        else-> AFregment()
    }
}

    override fun getCount()=3//뷰페이지 갯수
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {//제거
        super.destroyItem(container, position, `object`)

    }
}