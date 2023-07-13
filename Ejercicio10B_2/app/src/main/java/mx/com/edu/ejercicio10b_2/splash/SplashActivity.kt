package mx.com.edu.ejercicio10b_2.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import mx.com.edu.ejercicio10b_2.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        launchApp()
    }

    fun launchApp(){
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, HomeSplashActivity::class.java))
            finish()
        }, 3000)
    }
}