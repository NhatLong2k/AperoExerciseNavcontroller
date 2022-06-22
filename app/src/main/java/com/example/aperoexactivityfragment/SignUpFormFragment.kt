package com.example.aperoexactivityfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.aperoexactivityfragment.databinding.FragmentSignUpFormBinding
import com.example.aperoexactivityfragment.model.User
import com.example.aperoexactivityfragment.viewmodel.UserViewModel

class SignUpFormFragment : Fragment() {

    lateinit var binding: FragmentSignUpFormBinding
    var email: String = ""
    val args: SignUpFormFragmentArgs by navArgs()

    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider(
            this,
            UserViewModel.UserViewModelFactory(requireActivity().application)
        ).get(UserViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpFormBinding.inflate(inflater, container, false)
        email = args.email
        Log.d("TAG", "onCreateView: $email")
        binding.txtSignUp.setOnClickListener {
            signUp()
        }
        binding.txtBack.setOnClickListener {
            activity?.onBackPressed()
        }
        return binding.root
    }

    fun signUp() {
        if (checkForm()) {
            val user = User(
                null,
                email,
                binding.edtPassword.text.toString(),
                binding.edtFullName.text.toString()
            )
            userViewModel.inserUser(user)
            Toast.makeText(context, R.string.signup_success, Toast.LENGTH_LONG).show()
            val intent: Intent = Intent(activity, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    fun checkForm(): Boolean {
        if (binding.edtFullName.text.toString() == "" || binding.edtPassword.text.toString() == "") {
            Toast.makeText(context, R.string.do_not_let_empty, Toast.LENGTH_LONG).show()
            return false
        }
        if (binding.edtPassword.text.toString() != binding.edtConfirmPassword.text.toString()) {
            Toast.makeText(context, R.string.error_confirm, Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}