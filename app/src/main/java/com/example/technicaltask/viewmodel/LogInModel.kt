package com.example.technicaltask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technicaltask.App
import com.example.technicaltask.model.AppDatabase
import com.example.technicaltask.model.UserDB
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class LogInModel(private val app: App) : ViewModel() {

    val logInLiveData = MutableLiveData<List<UserDB>>()



    fun searchUserFN(fn: String){
        viewModelScope.launch {
            app.searchUser(fn)
            getDB()
        }
    }



    private fun getDB(){

        viewModelScope.launch{
            logInLiveData.value = app.getAllUsers()
        }
    }

}
