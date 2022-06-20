package com.example.aperoexactivityfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.aperoexactivityfragment.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_sign_up, container, false)
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding.txtJoinNow.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_signUpFragment_to_signUpFormFragment)
        }
        binding.txtSignIn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_signUpFragment_to_signInFragment)
        }
        return binding.root
    }
}