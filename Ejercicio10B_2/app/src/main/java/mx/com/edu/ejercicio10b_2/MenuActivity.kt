package mx.com.edu.ejercicio10b_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.com.edu.ejercicio10b_2.calculadora.mvp.view.CalculadoraActivity
import mx.com.edu.ejercicio10b_2.databinding.ActivityMenuBinding
import mx.com.edu.ejercicio10b_2.listas.ListaActivity
import mx.com.edu.ejercicio10b_2.mvvm.calcular.view.CalculadoraMvvwActivity
import mx.com.edu.ejercicio10b_2.mvvm.view.RegistroMvvmActivity
import mx.com.edu.ejercicio10b_2.retrofit.MainRestActivity
import mx.com.edu.ejercicio10b_2.retrofit.RestActivity
import mx.com.edu.ejercicio10b_2.room.RegistroEmpleadoActivity
import mx.com.edu.ejercicio10b_2.splash.SplashActivity

class MenuActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVistas.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.btnSplash.setOnClickListener {
            startActivity(Intent(this, SplashActivity::class.java))
        }

        binding.btnListas.setOnClickListener {
            startActivity(Intent(this, ListaActivity::class.java))
        }

        binding.btnEmpleado.setOnClickListener {
            startActivity(Intent(this, RegistroEmpleadoActivity::class.java))
        }

        binding.btnCalculadora.setOnClickListener {
            startActivity(Intent(this, CalculadoraActivity::class.java))
        }

        binding.btnMvvw.setOnClickListener {
            startActivity(Intent(this, RegistroMvvmActivity::class.java))
        }

        binding.btnMvvwCalculadora.setOnClickListener {
            startActivity(Intent(this, CalculadoraMvvwActivity::class.java))
        }

        binding.btnRetrofit.setOnClickListener {
            startActivity(Intent(this, MainRestActivity::class.java))
        }

    }
}