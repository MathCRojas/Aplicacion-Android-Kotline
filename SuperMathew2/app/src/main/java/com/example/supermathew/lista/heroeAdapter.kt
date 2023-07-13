package com.example.supermathew.lista

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.supermathew.databinding.ItemBinding

class heroeAdapter(context: Context): ListAdapter<Heroe, heroeAdapter.ViewHolder>(DiffutilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var item = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class ViewHolder(private val binding:ItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(element: Heroe, position: Int) = with(binding){
            binding.nombre.text = element.nombre
            binding.habilidad.text = element.habilidad
            binding.anio.text = element.anio


        }
    }
}

private object DiffutilCallback: DiffUtil.ItemCallback<Heroe>() {
    override fun areItemsTheSame(oldItem: Heroe, newItem: Heroe): Boolean {
        return oldItem.nombre == newItem.nombre
    }

    override fun areContentsTheSame(oldItem: Heroe, newItem: Heroe): Boolean {
        return newItem == oldItem
    }
}