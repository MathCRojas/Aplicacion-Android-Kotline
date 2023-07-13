package mx.com.edu.ejercicio10b_2.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import mx.com.edu.ejercicio10b_2.EjerciciosApplication.Companion.room
import mx.com.edu.ejercicio10b_2.databinding.ActivityRegistroEmpleadoBinding
import java.lang.Integer.parseInt

class RegistroEmpleadoActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistroEmpleadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroEmpleadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.guardar.setOnClickListener {
            if(binding.nombre.text.toString().isNullOrBlank() ||
            binding.paterno.text.toString().isNullOrBlank() ||
            binding.edad.text.toString().isNullOrBlank()){
                Toast.makeText(applicationContext,"Please complete the form",Toast.LENGTH_SHORT).show()
            }else{
                lifecycleScope.launch{
                    room.getEmpleadoDao().insert(
                        EmpleadoEntity(null,
                            binding.nombre.text.toString(),
                            binding.paterno.text.toString(),
                            parseInt(binding.edad.text.toString()))
                    )
                }
            }
        }

        binding.consultar.setOnClickListener {
            lifecycleScope.launch{
                Toast.makeText(applicationContext,"size of list -> "
                        + room.getEmpleadoDao().getAll().size,Toast.LENGTH_SHORT).show()
            }

        }

    }
}