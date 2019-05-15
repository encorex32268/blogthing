package com.lee.permissionask

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val RC_PERMISSION = 101
    val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->

            val contactPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
            val imagePermission = ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE)

            if (
                contactPermission != PackageManager.PERMISSION_GRANTED ||
                imagePermission != PackageManager.PERMISSION_GRANTED
                    ){
                ActivityCompat.requestPermissions(this,
                    arrayOf(
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                         ),
                    RC_PERMISSION)
            }else{
                toGetData()
            }


        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == RC_PERMISSION){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                toGetData()
            }
        }
    }

    private fun toGetData() {
        Log.d(TAG, "toGetData: Contacts")
        var cursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,null,null,null,null
        )
        cursor?.let {
            while (it.moveToNext()){
                val id = it.getString(it.getColumnIndex(ContactsContract.Contacts._ID))
                val name = it.getString(it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                Log.d(TAG, "toGetData: contacts :  id = $id  / name = $name")
            }
        }
        Log.d(TAG, "toGetData: Images")
        var imageCursor = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,null,null,null,null
        )
        imageCursor?.let {
            while (it.moveToNext()){
                val path = it.getString(it.getColumnIndex(MediaStore.Images.Media.DATA))
                Log.d(TAG, "toGetData: Image $path")
            }
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
