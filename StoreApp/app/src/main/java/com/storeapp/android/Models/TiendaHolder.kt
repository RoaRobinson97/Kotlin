package com.storeapp.android.Models

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.storeapp.android.R
import com.storeapp.android.TiendaActivity

class TiendaViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var tituloView: TextView? = null
    private var descirpcionView: TextView? = null
    private var ciudadView: TextView? = null

    init {
        tituloView = itemView.findViewById(R.id.tipo)
        descirpcionView = itemView.findViewById(R.id.descripcion)
        ciudadView = itemView.findViewById(R.id.ciudad)

    }

    fun bind(tienda: Tienda) {
        tituloView?.text = tienda.tipo
        descirpcionView?.text = tienda.descripcion
        ciudadView?.text = tienda.ciudad
    }

}


class PromoViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.promo_list_item, parent, false)) {

    var context: Context = inflater.context



    private var tiendaView: TextView? = null
    private var descirpcionView: TextView? = null
    private var precioView: TextView? = null
    private var fotoView: ImageView? = null


    init {
        tiendaView = itemView.findViewById(R.id.tienda)
        descirpcionView = itemView.findViewById(R.id.descripcion)
        precioView = itemView.findViewById(R.id.precio)
        fotoView = itemView.findViewById(R.id.foto)

    }

    fun bind(promo: Promo) {
        tiendaView?.text = promo.tienda
        descirpcionView?.text = promo.descripcion
        precioView?.text = promo.precio
        Picasso.get().load(promo.foto).into(fotoView)
        fotoView?.setOnClickListener{
            val intent = Intent(context, TiendaActivity::class.java)
            // To pass any data to next activity
            intent.putExtra("TIENDA", promo.tienda)
            // start your next activity
            context.startActivity(intent)
        }
    }

}

