package com.example.supermathew.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.supermathew.MenuActivity
import com.example.supermathew.PersonajeApplication.Companion.room
import com.example.supermathew.databinding.ActivityRegistroBinding
import kotlinx.coroutines.launch

class RegistroActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            if(!binding.nombre.text.isNullOrEmpty() ||
            !binding.habilidad.text.isNullOrEmpty()||
            !binding.anio.text.isNullOrEmpty()){
                lifecycleScope.launch {
                    room.getPersonajeDao().insert(
                        PersonajeEntity(null,
                            binding.nombre.text.toString(),
                            binding.habilidad.text.toString(),
                            binding.anio.text.toString())
                    )
                }
                Toast.makeText(this, "Personaje creado!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MenuActivity::class.java))
            }

            Toast.makeText(this, "Campos nulos", Toast.LENGTH_SHORT).show()

        }

    }
}