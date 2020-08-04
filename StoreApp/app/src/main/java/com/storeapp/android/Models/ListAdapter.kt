package com.storeapp.android.Models

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val list: List<Tienda>)
    : RecyclerView.Adapter<TiendaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiendaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TiendaViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TiendaViewHolder, position: Int) {
        val tienda: Tienda = list[position]
        holder.bind(tienda)
    }

    override fun getItemCount(): Int = list.size

}

class PromoListAdapter(private val list: List<Promo>)
    : RecyclerView.Adapter<PromoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PromoViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        val promo: Promo = list[position]
        holder.bind(promo)
    }

    override fun getItemCount(): Int = list.size

}