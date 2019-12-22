package com.lihan.kotlinretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val users : ArrayList<User>) : RecyclerView.Adapter<UserViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_users,parent,false))
    }
    override fun getItemCount(): Int = if (users.size==0) 0 else users.size
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindTo(users[position])
        holder.itemView.tag = position

    }

}