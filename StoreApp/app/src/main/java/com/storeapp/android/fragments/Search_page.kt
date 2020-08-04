package com.storeapp.android.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.database.*
import com.storeapp.android.Models.Tienda
import com.storeapp.android.R
import com.storeapp.android.databinding.FragmentSearchBinding


class Search_page : Fragment(R.layout.fragment_search), View.OnClickListener {

    lateinit var fragmentStoreList: StoreListFragment
    private lateinit var binding: FragmentSearchBinding
    lateinit var context: AppCompatActivity

    override fun onClick(v: View?) {

        var supportFragmentManager = super.getFragmentManager()

        when(v?.id){
            R.id.button_chicken ->{
                fragmentStoreList = StoreListFragment()
                supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fragment_container, fragmentStoreList)
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    ?.commit()
            }
            R.id.button_hamburger ->{

            }
            R.id.button_pizza ->{

            }
            R.id.button_pasta ->{

            }
            R.id.button_desserts ->{

            }
            R.id.button_others ->{

            }

        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context as AppCompatActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)

        binding.buttonChicken.setOnClickListener(this)
        binding.buttonHamburger.setOnClickListener(this)
        binding.buttonPasta.setOnClickListener(this)
        binding.buttonPizza.setOnClickListener(this)
        binding.buttonDesserts.setOnClickListener(this)
        binding.buttonOthers.setOnClickListener(this)

        //generateList(binding)

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}
