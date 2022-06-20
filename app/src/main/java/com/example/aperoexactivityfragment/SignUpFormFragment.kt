package com.example.aperoexactivityfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.aperoexactivityfragment.databinding.FragmentSignInBinding
import com.example.aperoexactivityfragment.databinding.FragmentSignUpFormBinding

class SignUpFormFragment : Fragment() {

    lateinit var binding: FragmentSignUpFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_sign_up_form, container, false)
        binding = FragmentSignUpFormBinding.inflate(inflater, container, false)
        binding.txtSignUp.setOnClickListener { Navigation.findNavController(binding.root).navigate(R.id.action_signUpFormFragment_to_signInFragment) }
        binding.txtBack.setOnClickListener {
            activity?.onBackPressed()
        }
        return binding.root
    }
}