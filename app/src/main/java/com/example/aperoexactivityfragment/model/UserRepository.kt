package com.example.aperoexactivityfragment.model

import android.app.Application
import androidx.lifecycle.LiveData

class UserRepository(app: Application) {
    private val userDao: UserDao

    init {
        val userDatabase: UserDatabase = UserDatabase.getInstance(app)
        userDao = userDatabase.getSongDao()
    }

    suspend fun insertUser(user: User) = userDao.insertUser(user)

    fun getAllUser(): LiveData<List<User>> = userDao.getAllUser()
}