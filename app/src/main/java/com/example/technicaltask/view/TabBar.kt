package com.example.technicaltask.view


import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.technicaltask.databinding.ActivityTabBarBinding


class TabBar : AppCompatActivity() {

    lateinit var binding: ActivityTabBarBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityTabBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val elProfile = binding.ellipseProfile
        val elHome = binding.ellipseHome
        val elLike = binding.ellipseLike
        val elBasket = binding.ellipseBasket
        val elMsg = binding.ellipseMsg

        val tagProfile = "profile"
        supportFragmentManager
            .beginTransaction()
            .add(binding.fragmentContainer.id, ProfileFr(), tagProfile)
            .commit()
        elProfile.visibility = VISIBLE




        binding.tabProfile.setOnClickListener {
            elProfile.visibility = VISIBLE
            supportFragmentManager
                .beginTransaction()
                .add(binding.fragmentContainer.id, ProfileFr(), tagProfile)
                .commit()
            elMsg.visibility = INVISIBLE
            elBasket.visibility = INVISIBLE
            elLike.visibility = INVISIBLE
            elHome.visibility = INVISIBLE
        }

        binding.tabLike.setOnClickListener {
            elLike.visibility = VISIBLE
            Toast.makeText(this, "LIKE", Toast.LENGTH_SHORT).show()
            elMsg.visibility = INVISIBLE
            elBasket.visibility = INVISIBLE
            elHome.visibility = INVISIBLE
            elProfile.visibility = INVISIBLE
        }

        binding.tabBasket.setOnClickListener {
            elBasket.visibility = VISIBLE
            Toast.makeText(this, "BASKET", Toast.LENGTH_SHORT).show()
            elMsg.visibility = INVISIBLE
            elHome.visibility = INVISIBLE
            elLike.visibility = INVISIBLE
            elProfile.visibility = INVISIBLE
        }

        binding.tabMsg.setOnClickListener {
            elMsg.visibility = VISIBLE
            Toast.makeText(this, "MSG", Toast.LENGTH_SHORT).show()
            elHome.visibility = INVISIBLE
            elBasket.visibility = INVISIBLE
            elLike.visibility = INVISIBLE
            elProfile.visibility = INVISIBLE
        }

        binding.tabHome.setOnClickListener {
            elHome.visibility = VISIBLE
            Toast.makeText(this, "HOME", Toast.LENGTH_SHORT).show()
            elMsg.visibility = INVISIBLE
            elBasket.visibility = INVISIBLE
            elLike.visibility = INVISIBLE
            elProfile.visibility = INVISIBLE
        }

    }

}