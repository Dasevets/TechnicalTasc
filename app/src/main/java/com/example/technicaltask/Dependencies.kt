package com.example.technicaltask

import android.content.Context
import androidx.room.Room
import com.example.technicaltask.model.AppDatabase

object Dependencies {

    private lateinit var applicationContext: Context

    fun init(context: Context){
        applicationContext = context
    }

    private val appDatabase : AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database.db")
            .build()
    }

    val userRep: App by lazy { App(appDatabase.getUserDao()) }


}