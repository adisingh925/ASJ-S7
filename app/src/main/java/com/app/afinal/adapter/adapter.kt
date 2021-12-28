package com.app.afinal.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.afinal.R
import com.app.afinal.database.database
import com.app.afinal.databinding.RowLayoutBinding
import com.app.afinal.model.model

class adapter() : RecyclerView.Adapter<adapter.myviewholder>() {

    lateinit var binding: RowLayoutBinding

    private var datalist = emptyList<model>()

    class myviewholder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        return myviewholder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false))
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.id).text = datalist[position].id.toString()
        holder.itemView.findViewById<TextView>(R.id.firstname).text = datalist[position].fname
        holder.itemView.findViewById<TextView>(R.id.lastname).text = datalist[position].lname
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    fun setdata(data : List<model>)
    {
        this.datalist = data
        notifyDataSetChanged()
    }
}