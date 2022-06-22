package com.example.aperoexactivityfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aperoexactivityfragment.adapter.UserAdapter
import com.example.aperoexactivityfragment.databinding.ActivityHomeBinding
import com.example.aperoexactivityfragment.model.User
import com.example.aperoexactivityfragment.viewmodel.UserViewModel

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    val userList = ArrayList<User>()

    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider(
            this,
            UserViewModel.UserViewModelFactory(application)
        ).get(UserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        getAllUser()
        setContentView(binding.root)
    }

    private fun getAllUser() {
        val adapter: UserAdapter = UserAdapter(this@HomeActivity, userList)
        binding.rvUser.setHasFixedSize(true)
        binding.rvUser.layoutManager = LinearLayoutManager(this)
        binding.rvUser.adapter = adapter
        userViewModel.getAllUser().observe(this, Observer {
            adapter.setUser(it)
        })
    }
}