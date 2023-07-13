package mx.com.edu.ejercicio10b_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import mx.com.edu.ejercicio10b_2.databinding.ActivityDetailBinding
import mx.com.edu.ejercicio10b_2.listas.Alumno

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var alumno = intent.getSerializableExtra("alumno") as Alumno

        binding.alumnoXml = alumno

        Glide.with(this).load(alumno.foto).into(binding.img)

        when (alumno.estatus) {
            "activo" -> binding.estatus.setTextColor(ContextCompat.getColor(this, R.color.verde))
            "eliminado" -> binding.estatus.setTextColor(ContextCompat.getColor(this, R.color.rojo))
            else -> binding.estatus.setTextColor(ContextCompat.getColor(this, R.color.gris))
        }
    }
}