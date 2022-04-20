package com.example.practica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val ini = findViewById<Button>(R.id.b1)
        ini.setOnClickListener{
            val pasar= Intent(this, inicio::class.java)
            startActivity(pasar)
        }

        val servi = findViewById<Button>(R.id.b2)
        servi.setOnClickListener{
            val pasar= Intent(this, servicios::class.java)
            startActivity(pasar)
        }

        val con = findViewById<Button>(R.id.b3)
        con.setOnClickListener{
            val pasar= Intent(this, contacto::class.java)
            startActivity(pasar)
        }
    }
}