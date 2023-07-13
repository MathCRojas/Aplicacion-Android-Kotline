package com.example.supermathew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.supermathew.databinding.ActivityMenuBinding
import com.example.supermathew.lista.ListaActivity
import com.example.supermathew.room.RegistroActivity

class MenuActivity : AppCompatActivity() {

    lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java))
        }

        binding.btnConsultar.setOnClickListener {
            startActivity(Intent(this, ListaActivity::class.java))
        }


    }
}