package mx.com.edu.ejercicio10b_2.calculadora.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import mx.com.edu.ejercicio10b_2.calculadora.mvp.presenter.MainPresenter
import mx.com.edu.ejercicio10b_2.databinding.ActivityCalculadoraBinding

class CalculadoraActivity : AppCompatActivity(), MainInterface {
    lateinit var binding: ActivityCalculadoraBinding
    lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculadoraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this)

        binding.btnSuma.setOnClickListener {
            presenter.makeSuma(binding.num1.text.toString(), binding.num2.text.toString())
        }

        binding.btnDivi.setOnClickListener {
            presenter.makeDivision(binding.num1.text.toString(), binding.num2.text.toString())
        }

        binding.btnMulti.setOnClickListener {
            presenter.makeMultiplicacion(binding.num1.text.toString(), binding.num2.text.toString())
        }

    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showResult(result: String) {
        binding.resultado.text = result
    }
}