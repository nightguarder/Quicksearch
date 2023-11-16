package com.example.quicksearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quicksearch.R
import com.example.quicksearch.model.LanguageData

class LanguageAdapter(private var mList: List<LanguageData>)
    : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {
    inner  class LanguageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val logo : ImageView = itemView.findViewById(R.id.logoItem)
        val titleTv : TextView = itemView.findViewById(R.id.ItemText)

    }
    //Fill the list found data
    fun setFilteredList(mList: List<LanguageData>){
        this.mList = mList
        notifyDataSetChanged()
    }
    //Change each Text for the item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return  LanguageViewHolder(view)
    }


    override fun getItemCount(): Int {
        return mList.size
    }
    //Change each logo for the item in the list
    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.logo.setImageResource(mList[position].logo)
        holder.titleTv.text = mList[position].title
    }


}