package mx.com.edu.ejercicio10b_2.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import mx.com.edu.ejercicio10b_2.databinding.ActivityRestBinding
import mx.com.edu.ejercicio10b_2.retrofit.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestActivity : AppCompatActivity() {

    lateinit var binding: ActivityRestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var adapter = AdapterUser(this)
        lifecycleScope.launch{
            var call = getRetrofit().create(ApiService::class.java).getAll("" +
                    "users/")
            runOnUiThread{
                if(call.isSuccessful){
                    System.out.println("Size-> "+call.body()!![0].name)
                    var usuarios: MutableList<User> = call.body() as MutableList<User>

                    binding.lv.layoutManager = LinearLayoutManager(applicationContext)

                    binding.lv.adapter = adapter
                    adapter.submitList(usuarios)
                    adapter.notifyDataSetChanged()
                }else{
                    System.out.println("Error")
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