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
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding.txtJoinNow.setOnClickListener {
            val action = SignUpFragmentDirections
                .actionSignUpFragmentToSignUpFormFragment(binding.edtEmail.text.toString())
            Navigation.findNavController(binding.root).navigate(action)
        }
        binding.txtSignIn.setOnClickListener {
            Navigation.findNavController(binding.root)
                .navigate(R.id.action_signUpFragment_to_signInFragment)
        }
        return binding.root
    }
}