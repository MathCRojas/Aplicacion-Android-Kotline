package mx.com.edu.ejercicio10b_2.retrofit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mx.com.edu.ejercicio10b_2.DetailActivity
import mx.com.edu.ejercicio10b_2.R
import mx.com.edu.ejercicio10b_2.databinding.ItemUserBinding

class AdapterUser(context: Context): ListAdapter<User, AdapterUser.ViewHolder>(AdapterUser.DiffUtilCallback) {
    val ctx = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var item = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(item);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position),position)
    }

    inner class ViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(element: User, position: Int) = with(binding){
            binding.nombre.text = element.name

            binding.nombre.setOnClickListener {
                var intent = Intent(ctx, UserDetailActivity::class.java);

                intent.putExtra("usuario", element)

                ctx.startActivity(intent)
            }

            if (element.status.equals("inactive")){
                binding.status.setBackgroundColor(ContextCompat.getColor(ctx, R.color.rojo))
            }else{
                binding.status.setBackgroundColor(ContextCompat.getColor(ctx, R.color.verde))
            }
        }
    }

    private object DiffUtilCallback:DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return newItem.id == oldItem.id
        }

    }
}