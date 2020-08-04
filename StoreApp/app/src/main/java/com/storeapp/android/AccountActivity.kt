package com.storeapp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.storeapp.android.Models.User
import kotlinx.android.synthetic.main.activity_account.*
import com.storeapp.android.databinding.ActivityAccountBinding

class AccountActivity : AppCompatActivity(R.layout.activity_account) {

    private lateinit var binding: ActivityAccountBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(toolbar)

        val intent = this.getIntent()
        val user: User = intent.getSerializableExtra("USER") as User

        var buttonGoBack = binding.buttonGoBack

        buttonGoBack.setOnClickListener {
            finish()
        }



    }
}
