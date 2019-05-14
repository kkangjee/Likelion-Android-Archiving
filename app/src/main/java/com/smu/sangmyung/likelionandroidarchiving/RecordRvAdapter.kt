package com.smu.sangmyung.likelionandroidarchiving

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class RecordRvAdapter (val context: Context, val recordList : ArrayList<RecordList>):
        RecyclerView.Adapter<RecordRvAdapter.Holder>(){

    inner class Holder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val recordImage = itemView.findViewById<ImageView>(R.id.iv_record)
        val recordName = itemView.findViewById<TextView>(R.id.tv_record)
        fun bind(record : RecordList,context:Context){ // 값을 넣을 때
            if (record.image !=""){//image가 빈칸일 경우 ic_launcher로 설정, 아니라면 drawable에 있는 파일의 이름을 받아와
                val resourceId = context.resources.getIdentifier(record.image,"drawable",context.packageName)
                //getIdentifier로 이름을 파일로 만들어준다
                recordImage.setImageResource(resourceId)//받아온 값으로 이미지를 설정한다
            }
            else
                recordImage.setImageResource(R.mipmap.ic_launcher)

            recordName.text = record.name

            //foodImage.setOnClickListener {
            //    Toast.makeText(context,"하이", Toast.LENGTH_SHORT).show()
            //}

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {//view를 가져온다
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_record,parent,false
        )
        //클릭시 나오는 것
        view.setOnClickListener {
            Toast.makeText(context,"하이", Toast.LENGTH_SHORT).show()
        }
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return recordList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {//몇번째 position에 순서대로 채운다
        holder.bind(recordList[position],context)
    }



}