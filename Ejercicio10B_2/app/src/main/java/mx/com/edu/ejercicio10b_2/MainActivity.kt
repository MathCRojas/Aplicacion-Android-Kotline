package mx.com.edu.ejercicio10b_2

import android.app.Person
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import mx.com.edu.ejercicio10b_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var persona = Persona(binding.nombre.text.toString(), binding.paterno.text.toString())

        binding.btn.setOnClickListener {
            startActivity(Intent(this, SaludoActivity::class.java).putExtra("persona", persona))
        }
    }
}