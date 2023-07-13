package mx.com.edu.ejercicio10b_2.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import mx.com.edu.ejercicio10b_2.databinding.ActivityListaBinding

class ListaActivity : AppCompatActivity(), AdapterAlumno.Eventos {

    lateinit var  binding:ActivityListaBinding
    var data:MutableList<Alumno> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityListaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        data.add(Alumno(
            "Manuel",
            "https://assets.entrepreneur.com/content/3x2/2000/20150820205507-single-man-outdoors-happy-bliss.jpeg",
            "default",
        "22"))

        data.add(Alumno(
            "Sofía",
            "https://assets.entrepreneur.com/content/3x2/2000/20150820205507-single-man-outdoors-happy-bliss.jpeg",
            "default",
            "21"))

        data.add(Alumno(
            "Rafael",
            "https://assets.entrepreneur.com/content/3x2/2000/20150820205507-single-man-outdoors-happy-bliss.jpeg",
            "default",
            "20"))

        data.add(Alumno(
            "Marcos",
            "https://assets.entrepreneur.com/content/3x2/2000/20150820205507-single-man-outdoors-happy-bliss.jpeg",
            "default",
            "23"))


        setData()
    }

    var adapter: AdapterAlumno? = null
    fun setData(){

        binding.lv.layoutManager = LinearLayoutManager(this)
        adapter = AdapterAlumno(this, this)
        binding.lv.adapter = adapter
        adapter!!.submitList(data)
        adapter!!.notifyDataSetChanged()
    }

    override fun onItemClick(element: Alumno, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onStatusChange(element: Alumno, position: Int, status: String) {
        data[position].estatus = status
        adapter!!.notifyItemChanged(position);
        Toast.makeText(this, "${element.nombre}", Toast.LENGTH_SHORT).show()
    }
}