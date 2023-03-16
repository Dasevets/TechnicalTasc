package com.example.technicaltask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.technicaltask.App
import com.example.technicaltask.model.AppDatabase
import com.example.technicaltask.model.UserDB
import kotlinx.coroutines.launch

class SignInModel( val app: App) : ViewModel() {


    fun insertToDB(userDB: UserDB){
        viewModelScope.launch {
            app.insertNewUser((userDB))
        }

    }
}