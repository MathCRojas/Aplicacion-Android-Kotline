package mx.com.edu.ejercicio10b_2.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import mx.com.edu.ejercicio10b_2.databinding.ActivityMainMvpBinding
import mx.com.edu.ejercicio10b_2.mvp.presenter.MainPresenter

class MainMvpActivity : AppCompatActivity(), MainInterface {

    lateinit var binding: ActivityMainMvpBinding
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMvpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this)

        binding.login.setOnClickListener {
            presenter.makeLogin(binding.usuario.text.toString(), binding.password.text.toString())
        }

    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showResult(result: String) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
    }
}