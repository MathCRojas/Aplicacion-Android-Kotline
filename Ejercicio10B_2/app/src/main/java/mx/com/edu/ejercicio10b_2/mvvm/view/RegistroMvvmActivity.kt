package mx.com.edu.ejercicio10b_2.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import mx.com.edu.ejercicio10b_2.databinding.ActivityRegistroMvvmBinding
import mx.com.edu.ejercicio10b_2.mvvm.viewmodel.RegistroViewModel

class RegistroMvvmActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistroMvvmBinding
    lateinit var viewModel: RegistroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(RegistroViewModel::class.java)

        binding.btn.setOnClickListener {
            viewModel.checkLogin(binding.nombre.text.toString(), binding.password.text.toString())
        }

        initObservers()

    }

    fun initObservers(){
        viewModel.result.observe(this,{
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.error.observe(this,{
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })
    }
}