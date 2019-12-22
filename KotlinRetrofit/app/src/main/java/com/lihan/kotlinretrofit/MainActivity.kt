package com.lihan.kotlinretrofit

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            CoroutineScope(Dispatchers.Default).launch {
                getUsersData()
            }
        }
    }

    private suspend fun getUsersData() {
        withContext(Dispatchers.Default) {
            val basicUrl = "https://test1222gitbook.appspot.com/"
            val retrofit = Retrofit.Builder()
                .baseUrl(basicUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service =retrofit.create(IUser::class.java)
            service.getUsers().enqueue(object:Callback<ArrayList<User>>{
                override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                    Toast.makeText(this@MainActivity,"Error : ${t.message}",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<ArrayList<User>>,
                    response: Response<ArrayList<User>>
                ) {
                    val data = response.body()
                    data?.let {
                        recyclerView.setHasFixedSize(true)
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        val adapter = UserAdapter(it)
                        recyclerView.adapter = adapter

                    }

                }

            })
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
