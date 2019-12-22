package com.lihan.kotlinretrofit

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_users.view.*

class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
    private val name: TextView = itemView.user_name
    private val id: TextView = itemView.user_id
    private val email: TextView = itemView.user_email

    fun bindTo(user : User){
        name.text = user.name
        id.text = user._id
        email.text = user.email

    }
}