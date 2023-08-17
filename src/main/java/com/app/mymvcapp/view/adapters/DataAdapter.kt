package com.app.mymvcapp.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.mymvcapp.DataPOJO
import com.app.mymvcapp.databinding.ContentUsersItemsBinding
import com.app.mymvcapp.utils.room.entity.Data

class DataAdapter(private val data: DataPOJO) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.ViewHolder {

        val binding : ContentUsersItemsBinding = ContentUsersItemsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    inner class ViewHolder (val binding: ContentUsersItemsBinding)  : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

      /*  holder.binding.txtvwId.text = data.get(position).id.toString()
        holder.binding.txtvwFirstName.text = data.get(position).first_name
        holder.binding.txtvwLastName.text = data.get(position).last_name*/

        holder.binding.txtvwId.text = data.data.get(position).id.toString()
        holder.binding.txtvwFirstName.text = data.data.get(position).first_name
        holder.binding.txtvwLastName.text = data.data.get(position).last_name

    /*    holder.binding.txtvwId.text = data.get(position).data.get(position).id.toString()
        holder.binding.txtvwFirstName.text = data.get(position).data.get(position).first_name
        holder.binding.txtvwLastName.text = data.get(position).data.get(position).last_name*/

    }

    override fun getItemCount(): Int {
        return data.data.size
    }

}