package com.lihan.kotlinretrofit

data class User(
    val _id: String,
    val email: String,
    val name: String

) {
    override fun toString(): String {
        return "User(_id='$_id', email='$email', name='$name')"
    }
}