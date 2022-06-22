package com.example.aperoexactivityfragment.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "user")
class User(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "Id") var id: Long?,
    @ColumnInfo(name = "Email") var email: String,
    @ColumnInfo(name = "Password") var password: String,
    @ColumnInfo(name = "FullName") var fullName: String
) : Serializable {
}