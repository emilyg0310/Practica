package com.example.practica

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.practica.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Registro : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private lateinit var auth: FirebaseAuth
    lateinit var datePickerDialog: DatePickerDialog

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_registro)

        binding.btnEnviarRegistro.setOnClickListener {
            val nombre = binding.eTxtNombreRegistro.text.toString()
            val apellido = binding.eTxtApellidoRegistro.text.toString()
            val email = binding.eTxtCorreoRegistro.text.toString()
            val password = binding.eTxtPasswordRegistro.text.toString()

            if (nombre.isNotEmpty() && apellido.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                registrarUsuario(
                    nombre,
                    apellido,
                    email,
                    password
                )
            } else {
                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show()
            }

        }
        auth = Firebase.auth
    }

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        } else {

        }
    }

    private fun registrarUsuario(
        nombre: String,
        apellido: String,
        email: String,
        password: String
    ){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val uid = user!!.uid
                    val map = hashMapOf(
                        "nombre" to nombre,
                        "apellido" to apellido,
                        "correo" to email
                    )
                    val db = Firebase.firestore
                    db.collection("users").document(uid).set(map).addOnSuccessListener {
                        infoUser()
                        Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show()
                    }
                        .addOnFailureListener {
                            Toast.makeText(
                                this,
                                "Fallo al guardar la informacion",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                } else {
                    Toast.makeText(
                        this, "Authenticacion fallida.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
         }

    private fun infoUser() {
        val infoUserIntent = Intent(this, ejercicios::class.java)
        startActivity(infoUserIntent)

    }

    private fun reload() {

    }
}