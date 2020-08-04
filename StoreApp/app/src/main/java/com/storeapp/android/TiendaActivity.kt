package com.storeapp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.storeapp.android.databinding.ActivityTiendaBinding

class TiendaActivity : AppCompatActivity(R.layout.activity_tienda) {

    private lateinit var binding: ActivityTiendaBinding



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityTiendaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = this.getIntent()
        val user: String = intent.getStringExtra("TIENDA")
        binding.textView2.text = user

    }
}
