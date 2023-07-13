package mx.com.edu.ejercicio10b_2.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.com.edu.ejercicio10b_2.databinding.ActivityMainRestBinding

class MainRestActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainRestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainRestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConsultar.setOnClickListener {
            startActivity(Intent(this, RestActivity::class.java))
        }

        binding.btnRegistrar.setOnClickListener {
            startActivity(Intent(this, RegistroRestActivity::class.java))
        }
    }
}