package com.lee.testitemtouchhelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_row.view.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var itemDatas : ArrayList<String>
    lateinit var mAdapter : ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemDatas = ArrayList()
        for (i in 1..20) {
            itemDatas.add("item$i")
        }

        itemRecycler.setHasFixedSize(true)
        itemRecycler.layoutManager = LinearLayoutManager(this)
        mAdapter = ItemAdapter()
        itemRecycler.adapter =mAdapter

        itemTouchHelper.attachToRecyclerView(itemRecycler)
    }
    private val itemTouchHelper = ItemTouchHelper(object: ItemTouchHelper.Callback(){
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder): Int {
            val dragFlags  = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            val swipeFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
           return makeMovementFlags(dragFlags,swipeFlags)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val fromInt = viewHolder.adapterPosition
            val toInt = target.adapterPosition
            mAdapter.moveItem(fromInt,toInt)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val pos = viewHolder.adapterPosition
            mAdapter.removeItem(pos)
        }

    })


    inner class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            return ItemViewHolder(layoutInflater.inflate(R.layout.item_row,parent,false))
        }

        override fun getItemCount() = itemDatas.size

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            holder.itemName.text = itemDatas[position]
        }

        fun moveItem(fromInt: Int, toInt: Int) {
            Collections.swap(itemDatas,fromInt,toInt)
            notifyItemMoved(fromInt,toInt)
        }

        fun removeItem(pos: Int) {
            itemDatas.removeAt(pos)
            notifyItemRemoved(pos)
        }


    }

    inner class ItemViewHolder(view: View):RecyclerView.ViewHolder(view){
        val itemName: TextView = view.itemname
    }
}
