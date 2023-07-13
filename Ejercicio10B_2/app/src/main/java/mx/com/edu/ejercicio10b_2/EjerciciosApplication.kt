package mx.com.edu.ejercicio10b_2

import android.app.Application
import androidx.room.Room
import mx.com.edu.ejercicio10b_2.room.Db

//Esta clase se utiliza para que antes de abrir cualquier actividad, inicialize room
class EjerciciosApplication : Application() {

    companion object{
        lateinit var room: Db
    }

    override fun onCreate() {
        super.onCreate()
        room = Room.databaseBuilder(applicationContext, Db::class.java, "Utez").build()
    }
}