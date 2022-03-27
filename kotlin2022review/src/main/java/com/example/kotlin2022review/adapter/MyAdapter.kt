package com.example.kotlin2022review

import android.content.res.Resources
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
//        val itemView= LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_view_linear_vertical_recyclerview, parent, false)

        val itemView= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_grid_recyclerview, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        val itemImageView = holder.itemView.findViewById<ImageView>(R.id.item_imageView)
        val itemlinear = holder.itemView.findViewById<LinearLayout>(R.id.item_linear)
        val itemTvCaption = holder.itemView.findViewById<TextView>(R.id.item_tv_caption)
        val itemTvContent= holder.itemView.findViewById<TextView>(R.id.item_tv_content)

        itemImageView.setImageResource(R.drawable.ic_launcher_background)
        //itemImageView.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.ic_launcher_foreground))
        //itemImageView.setImageBitmap(BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.ic_launcher_background))

        itemTvCaption.text="\"$position 标题的附件奥兰多\""
        itemTvContent.text="\"I love Canada,I love Canada,I love Canada,v\\I love Canada\n" +
                "I love CanadaI love Canada\\,I love Canada,I love Canada\""


    }

    override fun getItemCount(): Int
    {
        //return 20
        return 50
    }



}

open class MyViewHolder(view:View):RecyclerView.ViewHolder(view)
{
}
