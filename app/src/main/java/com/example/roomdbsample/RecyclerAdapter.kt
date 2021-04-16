package com.example.roomdbsample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var context: Context, var contentList: List<ContentText>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false)
        val recyclerViewHolder =RecyclerViewHolder(view, context)
        return recyclerViewHolder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RecyclerViewHolder).setView(contentList, position)
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

}
