package mx.com.edu.ejercicio10b_2.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [EmpleadoEntity::class],
    version = 1
)
abstract class Db : RoomDatabase() {

    abstract fun getEmpleadoDao(): EmpleadoDao
}