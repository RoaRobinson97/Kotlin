package com.storeapp.android.Models

import android.content.ContentValues.TAG
import android.text.method.TextKeyListener.clear
import android.util.Log
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

class DataBaseProvider {

    val marksRef = FirebaseDatabase.getInstance().getReference("Tiendas")
    val messageList = ArrayList<Tienda>()

    fun writeNewStore(storeName: String, tienda: Tienda) {
        marksRef.child(storeName).setValue(tienda)
    }


}
@IgnoreExtraProperties
class Tienda{

    var ciudad: String?= ""
    var descripcion: String?= ""
    var foto: String?= ""
    var pais: String?= ""
    var tipo: String?= ""

    constructor(){}

    @Exclude
    fun toMap(): Map<String, Any>{
        val result = HashMap<String, Any>()
        result.put("ciudad",ciudad!!)
        result.put("descripcion",descripcion!!)
        result.put("foto",foto!!)
        result.put("pais",pais!!)
        result.put("tipo",tipo!!)

        return result
    }


}

@IgnoreExtraProperties
class Promo{

    var descripcion: String?= ""
    var foto: String?= ""
    var precio: String?= ""
    var tienda: String?= ""

    constructor(){}

    @Exclude
    fun toMap(): Map<String, Any>{
        val result = HashMap<String, Any>()
        result.put("descripcion",descripcion!!)
        result.put("foto",foto!!)
        result.put("precio",precio!!)
        result.put("tienda",tienda!!)

        return result
    }


}