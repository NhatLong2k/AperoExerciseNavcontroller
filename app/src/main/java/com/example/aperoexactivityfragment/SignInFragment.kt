package com.example.aperoexactivityfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.aperoexactivityfragment.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    lateinit var binding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater, container, false)

        binding.txtSignUp.setOnClickListener { Navigation.findNavController(binding.root).navigate(R.id.action_signInFragment_to_signUpFormFragment) }

        binding.txtBack.setOnClickListener {
            activity?.onBackPressed()
        }
        return binding.root
    }
}