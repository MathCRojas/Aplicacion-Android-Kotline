package mx.com.edu.ejercicio10b_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.com.edu.ejercicio10b_2.databinding.ActivitySaludoBinding

class SaludoActivity : AppCompatActivity() {

    lateinit var  binding: ActivitySaludoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaludoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var persona = intent.getSerializableExtra("persona") as Persona

        binding.personaXml = persona
    }
}