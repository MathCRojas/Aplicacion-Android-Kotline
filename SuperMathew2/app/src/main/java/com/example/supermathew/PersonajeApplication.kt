package com.example.supermathew

import android.app.Application
import androidx.room.Room
import com.example.supermathew.room.Db

class PersonajeApplication: Application() {

    companion object{
        lateinit var room: Db
    }

    override fun onCreate() {
        super.onCreate()
        room = Room.databaseBuilder(applicationContext, Db::class.java, "heroes").build()
    }

}