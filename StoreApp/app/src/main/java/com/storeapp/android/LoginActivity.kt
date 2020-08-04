package com.storeapp.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.storeapp.android.Models.User
import com.storeapp.android.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(R.layout.activity_login) {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loginButton: Button = binding.buttonSignIn
        val loginEmail: EditText = binding.editTextLoginEmail
        val loginPassword: EditText = binding.editTextLoginPassword
        val wrongPassword: TextView = binding.textViewWrongUser


        loginButton.setOnClickListener {

            var user = User(
                loginEmail.text.toString(),
                loginPassword.text.toString()
            )
            if (!user.validate()) {
                loginPassword.setText("")
                wrongPassword.visibility = View.VISIBLE
            }
            else{
                goToHomePage(user)
                loginPassword.setText("")
            }
        }


    }

    fun goToHomePage(user: User) {

        val intent = Intent(this, HomeActivity::class.java)
        // To pass any data to next activity
        intent.putExtra("USER", user)
        // start your next activity
        startActivity(intent)
    }

}
