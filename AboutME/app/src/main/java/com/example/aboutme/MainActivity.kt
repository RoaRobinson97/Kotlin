package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.nickname_button).setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickName_edit)
        val nickNameEditText = findViewById<TextView>(R.id.nickName_edit)

        nickNameEditText.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nickNameEditText.visibility = View.VISIBLE

        //HIDE THE KEYBOARD
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken,0)
    }
}
