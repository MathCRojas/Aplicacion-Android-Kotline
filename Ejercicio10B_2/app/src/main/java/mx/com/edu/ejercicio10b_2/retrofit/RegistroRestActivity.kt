package mx.com.edu.ejercicio10b_2.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import mx.com.edu.ejercicio10b_2.databinding.ActivityRegistroRestBinding
import mx.com.edu.ejercicio10b_2.retrofit.service.ApiService
import mx.com.edu.ejercicio10b_2.utils.LoadingScreen
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegistroRestActivity : AppCompatActivity() {
    lateinit var binding : ActivityRegistroRestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroRestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnviar.setOnClickListener {
            lifecycleScope.launch{
                var call = getRetrofit().create(ApiService::class.java).create(
                    "users/", User(null,
                        binding.nombre.text.toString(),
                        binding.email.text.toString(),
                        binding.genero.text.toString(),
                        binding.estatus.text.toString()), "Bearer e3d5460f12bb58a1b7d8c309df27129255b4f329b7160efc16c4aaed68a7b8ef")
                runOnUiThread{
                    if(call.isSuccessful){
                        System.out.println("Id-> " + call.body()!!.id)
                        Toast.makeText(applicationContext, "Creacion exitosa", Toast.LENGTH_SHORT).show()
                        var intent = Intent(applicationContext, UserDetailActivity::class.java)
                        intent.putExtra("user", call.body()!!.id)
                        startActivity(intent)
                    }else{
                        System.out.println("Error")
                    }

                }
            }
        }

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gorest.co.in/public/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}