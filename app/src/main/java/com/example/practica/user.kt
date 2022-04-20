package com.example.practica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.practica.databinding.ActivityUserBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class user : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_user)

        auth = Firebase.auth

        val currentUser = auth.currentUser
        val uid = currentUser!!.uid
        val db = Firebase.firestore

        db.collection("users").document(uid).get().addOnSuccessListener {
            binding.eTxtNombreUser.text = ("Nombre: " + it.get("nombre") as String?)
            binding.eTxtApellidoUser.text = ("Apellido: " + it.get("apellido") as String?)
            binding.eTxtCorreoUser.text = ("Correo: " + it.get("correo") as String?)
        }

        binding.btnLogout.setOnClickListener {
            cerrarSesion()
        }
    }

    private fun cerrarSesion() {
        auth.signOut()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(
            intent
        )
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        } else {

        }
    }

    private fun reload() {

    }
}