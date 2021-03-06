package com.example.link

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

/*activity_subchart.xml 내 RecyclerView에 표시 될 아이템 뷰를 생성하는 adapter를 구현한 파일
* 아이템을 생성하고 들어갈 데이터를 저장한다.*/
class RcviewAdapter(val context: Context, val subDataList: ArrayList<SubData>, val itemClick: (SubData)-> Unit) :
    RecyclerView.Adapter<RcviewAdapter.Holder>() {

    //아이템뷰를 위한 viewHolder 객체를 생성하고 리턴
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.subchart_item, parent, false)
        return Holder(view, itemClick)
    }

    //위 onCreateViewHolder에서 만든 뷰홀더와 position에 해당하는 데이터를 아이템뷰에 표시
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(subDataList[position], context)
    }

    //전체 데이터 수 리턴
    override fun getItemCount(): Int {
        return subDataList.size
    }

    //아이템뷰를 저장하는 뷰홀더 클래스
    inner class Holder(itemView: View?, val itemClick: (SubData)-> Unit) : RecyclerView.ViewHolder(itemView!!) {

        val subLogoImg1 = itemView?.findViewById<CircleImageView>(R.id.mLogoImgView)
        val subTitle = itemView?.findViewById<TextView>(R.id.mSubTitle)
        val subTag = itemView?.findViewById<TextView>(R.id.subTag)

        //뷰홀더에 각 데이터를 입력하는 함수
        fun bind(subData: SubData, context: Context) {

            if (subData.subLogoImg != "") {
                val resourceId = context.resources.getIdentifier(subData.subLogoImg, "drawable", context.packageName)
               subLogoImg1?.setImageResource(resourceId)
            } else {
                subLogoImg1?.setImageResource(android.R.drawable.stat_sys_warning)
            }
            subTitle?.text = subData.subTitle
            subTag?.text = subData.subTag

            //아이템뷰를 클릭했을 때 이벤트 처리 및 데이터 전달
            val pos = adapterPosition

            if(pos != RecyclerView.NO_POSITION) {
                itemView.setOnClickListener {
                    itemClick(subData)
                }
            }
        }
    }

}