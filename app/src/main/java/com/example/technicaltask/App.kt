package com.example.technicaltask

import android.app.Application
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.RoomDatabase
import com.example.technicaltask.model.AppDatabase
import com.example.technicaltask.model.UserDB
import com.example.technicaltask.model.UserDao
import com.example.technicaltask.viewmodel.LogInModel
import com.example.technicaltask.viewmodel.SignInModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class App(private val userDao: UserDao) {


    suspend fun insertNewUser(userDB: UserDB){
        withContext(Dispatchers.IO){
            userDao.insertUser(userDB)
        }
    }

    suspend fun getAllUsers(): List<UserDB>{
        return  withContext(Dispatchers.IO){
            return@withContext userDao.getAllUsers()
        }
    }

    suspend fun searchUser(fn: String){
        withContext(Dispatchers.IO){
            userDao.searchUserByFirstName(fn)
        }
    }


}