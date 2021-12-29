package com.app.afinal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.afinal.databinding.RowLayoutBinding
import com.app.afinal.model.model

class adapter() : RecyclerView.Adapter<adapter.myviewholder>() {

    private lateinit var binding: RowLayoutBinding

    private var datalist = emptyList<model>()

    class myviewholder(binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        val id = binding.id
        val firstname = binding.firstname
        val lastname = binding.lastname
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return myviewholder(binding)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.id.text = datalist[position].id.toString()
        holder.firstname.text = datalist[position].fname
        holder.lastname.text = datalist[position].lname
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