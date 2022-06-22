package com.example.aperoexactivityfragment.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.aperoexactivityfragment.model.User
import com.example.aperoexactivityfragment.model.UserRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class UserViewModel(application: Application): ViewModel() {
    private val userRepository: UserRepository = UserRepository(application)

    fun inserUser(user: User) = viewModelScope.launch {
        userRepository.insertUser(user)
    }

    fun getAllUser(): LiveData<List<User>> = userRepository.getAllUser()

    class UserViewModelFactory(val application: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(UserViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return UserViewModel(application) as T
            }
            throw IllegalArgumentException("Không thể construce viewmodel")
        }
    }
}