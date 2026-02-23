package com.example.project_akhir.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_akhir.databinding.ItemRowShoeBinding
import com.example.project_akhir.model.ShoesData

class ListShoesAdapter (private val lisShoes: ArrayList<ShoesData>) : RecyclerView.Adapter<ListShoesAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemRowShoeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowShoeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,description, photo) = lisShoes[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text=name
        holder.binding.tvItemDescription.text= description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("EXTRA_SHOE",lisShoes[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int =lisShoes.size

}