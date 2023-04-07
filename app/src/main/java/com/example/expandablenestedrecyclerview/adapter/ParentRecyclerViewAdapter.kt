package com.example.expandablenestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablenestedrecyclerview.data.ParentItem
import com.example.expandablenestedrecyclerview.R

class ParentRecyclerViewAdapter(private val parentList: List<ParentItem>):
    RecyclerView.Adapter<ParentRecyclerViewAdapter.ParentViewHolder>() {

    inner class ParentViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val title: TextView =itemView.findViewById(R.id.parentTitleTv)
        val image:ImageView=itemView.findViewById(R.id.parentLogoIv)
        val childRecyclerView:RecyclerView=itemView.findViewById(R.id.childRecyclerView)
        val constraintLayout: ConstraintLayout =itemView.findViewById(R.id.constraintLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.parent_item,parent,false)
        return ParentViewHolder(view)
    }

    override fun getItemCount(): Int {
       return parentList.size
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val parentItem=parentList[position]
       holder.title.text=parentItem.title
        holder.image.setImageResource(parentItem.image)
        holder.childRecyclerView.setHasFixedSize(true)
        holder.childRecyclerView.layoutManager=GridLayoutManager(holder.itemView.context,3)

       val adapter= ChildRecyclerViewAdapter(parentItem.childList)
        holder.childRecyclerView.adapter=adapter

        // Expandable Functionality
        val isExpandable=parentItem.isExpandable
        holder.childRecyclerView.visibility=if (isExpandable)View.VISIBLE else View.GONE

        holder.constraintLayout.setOnClickListener {
            isAnyItemExpanded(position)
            parentItem.isExpandable=!parentItem.isExpandable  //Reverse the result of isExpandable
            notifyItemChanged(position)
        }
    }

    private fun isAnyItemExpanded(position: Int) {

        val temp=parentList.indexOfFirst{
            it.isExpandable
        }
        if(temp>=0 && temp!=position){
            parentList[temp].isExpandable=false
            notifyItemChanged(temp)
        }
    }
}