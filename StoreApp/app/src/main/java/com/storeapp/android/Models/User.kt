package com.storeapp.android.Models

import java.io.Serializable

data class User(var email: String, var password: String) : Serializable {

    fun validate(): Boolean {
        if (searchEmail(email, password ))
            return true
        else
            return false
    }
}

fun searchEmail(email: String, password: String): Boolean{
    if (email == "roa.robinson97@gmail.com" && password == "1234")
        return true
    else
        return false
}
