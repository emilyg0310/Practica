package com.example.practica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ejercicios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicios)

        val clini = findViewById<Button>(R.id.bi1)
        clini.setOnClickListener{
            val pasar= Intent(this, inicio::class.java)
            startActivity(pasar)
        }

        val tar = findViewById<Button>(R.id.bi2)
        tar.setOnClickListener{
            val pasar= Intent(this, tareas::class.java)
            startActivity(pasar)
        }
    }
}