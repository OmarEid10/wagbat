package com.mkrdeveloper.nestedrecyclerviewexample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wagbat.R
import com.mkrdeveloper.nestedrecyclerviewexample.models.ChildDataClass

class ChildAdapter(val childList: List<ChildDataClass>) :
    RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val dishName: TextView = itemView.findViewById(R.id.dishName)
        val price: TextView = itemView.findViewById(R.id.price)

        val imgChild: ImageView = itemView.findViewById(R.id.img_child)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.child_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = childList[position]

        holder.dishName.text = currentItem.dishName
        holder.price.text = currentItem.price
        holder.imgChild.setImageResource(currentItem.image)

    }

    override fun getItemCount(): Int {
        return childList.size
    }
}