package com.example.aperoexactivityfragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aperoexactivityfragment.R
import com.example.aperoexactivityfragment.model.User

class UserAdapter(
    private val context: Context,
    private val userList: ArrayList<User>,
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.txtEmail.text = user.email
        holder.txtName.text = user.fullName
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setUser(list: List<User>) {
        userList.addAll(list)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtEmail: TextView = itemView.findViewById(R.id.txt_item_user_email)
        val txtName: TextView = itemView.findViewById(R.id.txt_item_user_name)
    }
}