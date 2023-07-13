package mx.com.edu.ejercicio10b_2.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.com.edu.ejercicio10b_2.databinding.ActivityHomeSplashBinding

class HomeSplashActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}