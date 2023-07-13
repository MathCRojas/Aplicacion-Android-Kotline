package mx.com.edu.ejercicio10b_2.listas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mx.com.edu.ejercicio10b_2.DetailActivity
import mx.com.edu.ejercicio10b_2.R
import mx.com.edu.ejercicio10b_2.SaludoActivity
import mx.com.edu.ejercicio10b_2.databinding.Item2Binding
import mx.com.edu.ejercicio10b_2.databinding.ItemBinding
import java.text.FieldPosition

class AdapterAlumno(private val eventos: AdapterAlumno.Eventos, context: Context): ListAdapter<Alumno, AdapterAlumno.ViewHolder>(DiffutilCallback) {
    val ctx = context

    interface Eventos {
        fun onItemClick(element: Alumno, position: Int)
        fun onStatusChange(element: Alumno, position: Int, status: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var item = Item2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class ViewHolder(private val binding:Item2Binding): RecyclerView.ViewHolder(binding.root){
        fun bind(element: Alumno, position: Int) = with(binding){
            binding.txtNombre.text = element.nombre

            Glide.with(ctx).load(element.foto).into(binding.img)

            if(element.estatus.isNullOrBlank()) {
                binding.indicador.setBackgroundColor(ContextCompat.getColor(ctx, R.color.gris))
            }

            binding.txtNombre.setOnClickListener {

                var intent = Intent(ctx, DetailActivity::class.java);

                intent.putExtra("alumno", element)

                ctx.startActivity(intent)
            }

            binding.check.setOnClickListener{
                this@AdapterAlumno.eventos.onStatusChange(element,position, "activo")
            }

            binding.delete.setOnClickListener{
                this@AdapterAlumno.eventos.onStatusChange(element,position, "eliminado")
            }
        }
    }
}

private object DiffutilCallback:DiffUtil.ItemCallback<Alumno>() {
    override fun areItemsTheSame(oldItem: Alumno, newItem: Alumno): Boolean {
        return oldItem.nombre == newItem.nombre
    }

    override fun areContentsTheSame(oldItem: Alumno, newItem: Alumno): Boolean {
        return newItem == oldItem
    }

}
