package com.example.expandablenestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablenestedrecyclerview.data.ChildItem
import com.example.expandablenestedrecyclerview.R

class ChildRecyclerViewAdapter(private val childList:ArrayList<ChildItem>)
    :RecyclerView.Adapter<ChildRecyclerViewAdapter.ChildViewHolder>(){

    inner class ChildViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val childTitle:TextView=itemView.findViewById(R.id.childTitleTv)
        val childLogo: ImageView =itemView.findViewById(R.id.childLogoIv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
      val view=LayoutInflater.from(parent.context).inflate(R.layout.child_item,parent,false)
        return ChildViewHolder(view)
    }

    override fun getItemCount(): Int {
        return childList.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val childItem=childList[position]
        holder.childTitle.text=childItem.title
        holder.childLogo.setImageResource(childItem.image)
    }
}