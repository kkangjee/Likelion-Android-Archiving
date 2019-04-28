package com.smu.sangmyung.likelionandroidarchiving

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView
import android.widget.LinearLayout

//1. 사용할 변수 초기화
//2. 점과 점사이의 거리 정하기-> dp를 pixel로 전환
//3. 원을 만든다
//4. 선택 된 점 표시
class CircleIndicator : LinearLayout {
    private var mContext: Context? = null
    private var mDefaultCircle: Int = 0
    private var mSelectCircle: Int = 0
    private var imgDot: MutableList<ImageView> = mutableListOf()


    //2번
    private val temp =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4.5f, resources.displayMetrics)

    constructor(context: Context) : super(context) {//view를 instance 화 시키기 위해 사용하는 생성자
        mContext = context
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {//xml파일을 만져주기 위해
        mContext = context
    }

    fun createDotPanel(count: Int, defaultCircle: Int, selectCircle: Int, position: Int) {//점 패널 만들기
        this.removeAllViews()

        mDefaultCircle = defaultCircle
        mSelectCircle = selectCircle

        for (i in 0 until count) {//0,1,2 count=3
            imgDot.add(ImageView(mContext).apply
            { setPadding(temp.toInt(), 0, temp.toInt(), 0) }) //왼쪽 오른쪽에 4.5 넣음
            this.addView(imgDot[i])//이미지를 넣어줌
        }
        selectDot(position)
    }

    fun selectDot(position: Int) {
        for (i in imgDot.indices) {//넣어준 숫자
            if (i == position) {
                imgDot[i].setImageResource(mSelectCircle)
            } else {
                imgDot[i].setImageResource(mDefaultCircle)
            }
        }
    }

}