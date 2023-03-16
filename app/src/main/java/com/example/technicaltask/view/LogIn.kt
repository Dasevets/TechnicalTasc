package com.example.technicaltask.view

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.technicaltask.Dependencies
import com.example.technicaltask.databinding.ActivityLogInBinding
import com.example.technicaltask.viewmodel.LogInModel

class LogIn : AppCompatActivity() {

    lateinit var binding: ActivityLogInBinding
    private val viewModel by lazy { LogInModel(Dependencies.userRep) }


    override fun onCreate(savedInstanceState: Bundle?) {

        Dependencies.init(applicationContext)

        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.button.setOnClickListener { searchUserButtonPressed() }
    }


    private fun searchUserButtonPressed() {

        viewModel.searchUserFN(binding.firstName.text.toString())



        viewModel.logInLiveData.observe(this) { it ->

            it.forEach {
                if ((it.firstName) == binding.firstName.text.toString()) {
                    startWork()
                } else {
                    notFound()
                }
            }
        }

    }

    private fun startWork() {
        val intent = Intent(this, TabBar::class.java)
        startActivity(intent)
    }


    private fun notFound() {

        binding.firstName.hint = "User not Found"
    }
}