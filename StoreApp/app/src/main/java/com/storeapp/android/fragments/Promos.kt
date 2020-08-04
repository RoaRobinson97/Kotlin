package com.storeapp.android.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.storeapp.android.Models.Promo
import com.storeapp.android.Models.PromoListAdapter
import com.storeapp.android.R
import com.storeapp.android.databinding.FragmentPromosBinding

class Fragment_Promos : Fragment(R.layout.fragment_promos) {


    private lateinit var binding: FragmentPromosBinding
    var lista: ArrayList<Promo> = ArrayList<Promo>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPromosBinding.bind(view)

        generateList()

    }

    fun generateList(/*binding: FragmentStoreListBinding*/){

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("promos")
        lista.clear()
        var aux: Promo = Promo()
        var value: Promo = Promo()

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                dataSnapshot.children.forEach {
                    value = it.getValue(Promo::class.java)!!
                    aux.tienda = value.tienda
                    aux.descripcion =value.descripcion
                    aux.precio =value.precio
                    aux.foto =value.foto
                    lista.add(aux)
                    aux = Promo()
                    value = Promo()
                }
                val reciclerview= binding.promoRecyclerView
                binding.promoRecyclerView.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = PromoListAdapter(lista)
                }


            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

}
