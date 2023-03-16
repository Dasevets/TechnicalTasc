package com.example.technicaltask.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.technicaltask.databinding.FragmentProfileBinding


class ProfileFr : Fragment() {

    lateinit var binding: FragmentProfileBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(inflater, container, false)


        binding.logOutGroup.setOnClickListener{
            val intent = Intent(this.context, SignInPage::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    companion object {
//        const val ARG_PAGE = "ARG_PAGE"
//        fun newInstance(page: Int): ProfileFr {
//            val args = Bundle()
//            args.putInt(ARG_PAGE, page)
//            val fragment = ProfileFr()
//            fragment.arguments = args
//            return fragment
//        }
    }

}