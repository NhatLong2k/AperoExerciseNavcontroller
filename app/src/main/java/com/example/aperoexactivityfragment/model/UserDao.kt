package com.example.aperoexactivityfragment.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert()
    suspend fun insertUser(user: User)

    @Query("select * from user")
    fun getAllUser(): LiveData<List<User>>
}