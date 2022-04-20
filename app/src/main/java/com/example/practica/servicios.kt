package com.example.practica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.practica.databinding.ActivityServiciosBinding

class servicios : AppCompatActivity() {

    private lateinit var binding: ActivityServiciosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiciosBinding.inflate(layoutInflater)
        setContentView(binding.root)


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

        binding.bb1.setOnClickListener {
            binding.texto.setText("Cita con especialistas, Pruebas covid-19, Financiamento de cirugías y procedimientos.")
        }
        binding.bb2.setOnClickListener {
            binding.texto.setText("El Hospital Clínica Bíblica pone a su disposición el siguiente sistema de cotizaciones. Simplemente llené el siguiente formulario según sus necesidades y nuestro personal de atención al cliente se pondrá en contacto con usted a la brevedad posible.")
        }
        binding.bb3.setOnClickListener {
            binding.texto.setText("Una epicrisis es un resumen clínico de un internamiento o consulta externa del paciente. Este resumen brinda información acerca del proceso de hospitalización desde el inicio de la enfermedad hasta su resolución.")
        }
        binding.bb4.setOnClickListener {
            binding.texto.setText("En su afán de ofrecer las mejores prestaciones a los clientes mediante un equipo médico y tecnología de la más alta calidad, el Hospital Clínica Bíblica pone a su disposición el siguiente sistema para realizar su proceso de preadmisión. Simplemente llené el siguiente formulario según sus necesidades y nuestro personal de atención al cliente se pondrá en contacto con usted a la brevedad posible.")
        }
    }
}