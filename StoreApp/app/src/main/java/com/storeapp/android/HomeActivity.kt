package com.storeapp.android

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.storeapp.android.Models.User
import com.storeapp.android.fragments.Fragment_Promos
import com.storeapp.android.fragments.Search_page
import com.storeapp.android.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity(R.layout.activity_home) {

    private lateinit var binding: ActivityHomeBinding
    lateinit var promoFragment: Fragment_Promos
    lateinit var searchFragment: Search_page

    override fun onBackPressed() {
        // super.onBackPressed(); // Comment this super call to avoid calling finish() or fragmentmanager's backstack pop operation.
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        /*MANAGES ONCLICK ITEMS ON ACTION BAR MENU*/
        toolbar.setOnMenuItemClickListener { item->
            when(item.itemId){
                R.id.account ->{
                    //get bundle data from previous activity
                    val intent = this.getIntent()
                    val user: User = intent.getSerializableExtra("USER") as User
                    goToAccountPage(user)
                }
                R.id.logout ->{
                    finish()
                }
            }
            true
        }


        promoFragment = Fragment_Promos()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, promoFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()

        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.promo -> {
                    promoFragment = Fragment_Promos()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, promoFragment)
                        .commit()
                }

                R.id.search -> {

                    searchFragment = Search_page()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, searchFragment)
                        .commit()
                }

            }
            true
        }



        setContentView(binding.root)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        // Inflate the menu; this adds items to the action bar if it is present.
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu);
        return true

    }


    fun goToAccountPage(user: User) {

        val intent = Intent(this, AccountActivity::class.java)
        // To pass any data to next activity
        intent.putExtra("USER", user)
        // start your next activity
        startActivity(intent)

    }

}
