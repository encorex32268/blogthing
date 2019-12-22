package com.lihan.kotlinretrofit

import retrofit2.Call
import retrofit2.http.GET

interface IUser {
    @GET("/users")
    fun getUsers() : Call<ArrayList<User>>
}