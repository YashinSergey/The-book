package com.example.thebook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import java.util.ArrayList

class TitleAdapter(private val mContext: Context, private val titleList: ArrayList<String>,
                   private val clickListener:
                   CustomItemClickListener) :
        RecyclerView.Adapter<TitleAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.title_layout, parent, false)
        val viewHolder = MyViewHolder(view)
        view.setOnClickListener { v -> clickListener.onItemClick(v, viewHolder.position) }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleText.text = titleList[position].replace("_", " ")
    }

    override fun getItemCount(): Int {
        return titleList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var titleText: TextView = itemView.findViewById(R.id.titleTextView)
    }
}
