package com.storeapp.android.fragments

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.storeapp.android.Models.Tienda
import com.storeapp.android.R
import com.storeapp.android.databinding.FragmentStoreListBinding
import com.storeapp.android.Models.ListAdapter
import kotlinx.android.synthetic.main.list_item.*

class StoreListFragment : Fragment(R.layout.fragment_store_list) {

    private lateinit var binding: FragmentStoreListBinding
    var lista: ArrayList<Tienda> = ArrayList<Tienda>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStoreListBinding.bind(view)

        generateList()

    }

    fun generateList(/*binding: FragmentStoreListBinding*/){

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("tiendas")
        lista.clear()
        var aux: Tienda = Tienda()
        var value: Tienda = Tienda()

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                dataSnapshot.children.forEach {
                    value = it.getValue(Tienda::class.java)!!
                    aux.ciudad = value.ciudad
                    aux.descripcion =value.descripcion
                    aux.tipo =value.tipo
                    aux.descripcion =value.descripcion
                    aux.pais =value.pais
                    lista.add(aux)
                    aux = Tienda()
                    value = Tienda()
                }
                val reciclerview= binding.storeRecyclerView
                binding.storeRecyclerView.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = ListAdapter(lista)
                }


            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

}
