package com.example.technicaltask.view

import android.content.Intent
import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.technicaltask.Dependencies

import com.example.technicaltask.databinding.ActivitySignInPageBinding
import com.example.technicaltask.model.UserDB
import com.example.technicaltask.viewmodel.SignInModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow


class SignInPage : AppCompatActivity() {

    private lateinit var binding: ActivitySignInPageBinding

   // private val signInModel = App.instance.signInModel
    private val viewModel by lazy { SignInModel(Dependencies.userRep) }

    override fun onCreate(savedInstanceState: Bundle?) {

        Dependencies.init(applicationContext)

        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivitySignInPageBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.logIn.setOnClickListener() {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }




        binding.button.setOnClickListener {
            addUserInfoButtonPressed()
        }



    }


    private fun addUserInfoButtonPressed() {
        val user = UserDB(
            firstName = binding.firstName.text.toString(),
            lastName = binding.lastName.text.toString(),
            eMail = binding.eMail.text.toString()
        )



//        val db = AppDatabase.getDb(this)
        if (isEditTextsEmpty()) {

            println("!!! IF")



                try {
                    viewModel.insertToDB(user)
                    saved()
                } catch (_: SQLiteConstraintException) {
                    registered()
                }



        } else Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
    }


    private fun registered() {
        binding.firstName.hint = "This user is registered!"
        Toast.makeText(this, "User is registered!", Toast.LENGTH_SHORT).show()

    }

    private fun saved() {
        Toast.makeText(this, "User saved!", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, TabBar::class.java)
        startActivity(intent)

    }


    private fun isEditTextsEmpty(): Boolean {

        val isFirstName = if (binding.firstName.text.toString().isNotBlank()) {
            binding.firstName.hint = null
            true
        } else {
            binding.firstName.hint = "Field is not be empty!"
            false
        }

        val isLastName = if (binding.lastName.text.toString().isNotBlank()) {
            binding.lastName.hint = null
            true
        } else {
            binding.lastName.hint = "Field is not be empty!"
            false
        }

        val isEMail = if (binding.eMail.text.toString().isNotBlank()) {

            val dog = "@"
            if (binding.eMail.text.toString().indexOf(dog) != -1) {
                binding.eMail.hint = null
                true
            } else {
                binding.eMail.hint = "It's not E-Mail"
                false
            }
        } else {
            binding.eMail.hint = "Field is not be empty!"
            false
        }

        return isFirstName && isLastName && isEMail
    }

}