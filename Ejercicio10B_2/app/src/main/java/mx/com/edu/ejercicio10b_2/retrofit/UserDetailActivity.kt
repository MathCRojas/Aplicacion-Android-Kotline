package mx.com.edu.ejercicio10b_2.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main_mvp.*
import kotlinx.coroutines.launch
import mx.com.edu.ejercicio10b_2.R
import mx.com.edu.ejercicio10b_2.databinding.ActivityUserDetailBinding
import mx.com.edu.ejercicio10b_2.listas.Alumno
import mx.com.edu.ejercicio10b_2.retrofit.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserDetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityUserDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var usuario = intent.getSerializableExtra("usuario") as User

        if(!usuario.name.isNullOrEmpty()){
            binding.userXml = usuario
        }else{
            lifecycleScope.launch{
                var call = getRetrofit().create(ApiService::class.java).getOne(
                    "users/"+intent.getIntExtra("user",0).toString()+"/","Bearer e3d5460f12bb58a1b7d8c309df27129255b4f329b7160efc16c4aaed68a7b8ef")
                runOnUiThread{
                    if(call.isSuccessful){
                        usuario = call.body() as User
                        binding.userXml = usuario
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