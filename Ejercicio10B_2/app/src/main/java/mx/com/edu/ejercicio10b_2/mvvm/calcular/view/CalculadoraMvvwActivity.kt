package mx.com.edu.ejercicio10b_2.mvvm.calcular.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import mx.com.edu.ejercicio10b_2.databinding.ActivityCalculadoraMvvwBinding
import mx.com.edu.ejercicio10b_2.mvvm.calcular.viewmodel.CalculadoraViewModel


class CalculadoraMvvwActivity : AppCompatActivity() {

    lateinit var binding: ActivityCalculadoraMvvwBinding
    lateinit var viewModel: CalculadoraViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraMvvwBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CalculadoraViewModel::class.java)

        binding.btnCirculo.setOnClickListener {
            viewModel.areaCirculo(binding.medida.text.toString())
        }

        binding.btnCuadrado.setOnClickListener {
            viewModel.areaCuadrado(binding.medida.text.toString())
        }

        binding.btnTriangulo.setOnClickListener {
            viewModel.areaTriangulo(binding.medida.text.toString())
        }

        initObservers()

    }

    fun initObservers(){
        viewModel.result.observe(this,{
            binding.resultado.text = it
        })

        viewModel.error.observe(this,{
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })
    }
}