package com.example.supermathew.lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.supermathew.PersonajeApplication.Companion.room
import com.example.supermathew.databinding.ActivityListaBinding
import kotlinx.coroutines.launch

class ListaActivity : AppCompatActivity() {
    lateinit var binding: ActivityListaBinding

    var data:MutableList<Heroe> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            for(heroe in room.getPersonajeDao().getAll()){
                data.add(Heroe(heroe.nombre, heroe.habilidad, heroe.año))
            }
            setData()

            Toast.makeText(applicationContext, "size -> " +
                    room.getPersonajeDao().getAll(), Toast.LENGTH_SHORT).show()
        }




    }

    var adapter: heroeAdapter? = null
    fun setData(){
        binding.lv.layoutManager = LinearLayoutManager(this)
        adapter = heroeAdapter(this)
        binding.lv.adapter = adapter
        adapter!!.submitList(data)
        adapter!!.notifyDataSetChanged()
    }
}