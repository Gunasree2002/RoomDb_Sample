package com.example.roomdbsample

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view) {
    var contentView:TextView = view.findViewById(R.id.content)
    fun setView(contentList: List<ContentText>, position: Int) {
        val allContentList = contentList.get(position)
        contentView.text = allContentList.content
    }

}
