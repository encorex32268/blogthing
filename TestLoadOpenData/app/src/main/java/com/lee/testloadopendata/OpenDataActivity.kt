package com.lee.testloadopendata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_DRAGGING
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_open_data.*
import kotlinx.android.synthetic.main.activity_open_data.view.*
import kotlinx.android.synthetic.main.parkinglot_row.view.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.info
import org.jetbrains.anko.uiThread
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList

class OpenDataActivity : AppCompatActivity() , AnkoLogger {

    lateinit var gsonData : Parking
    lateinit var nowDat : Parking
    val RELOAD_COUNT = 10
    lateinit var mAdapter : ParkingAdapter
    lateinit var mLayoutManager : LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_data)

        doAsync {
            val jsonPath = "http://data.tycg.gov.tw/opendata/datalist/datasetMeta/download?id=f4cc0b12-86ac-40f9-8745-885bddc18f79&rid=0daad6e6-0632-44f5-bd25-5e1de1e9146f"
            val readText = URL(jsonPath).readText()
            info(readText)
            gsonData = Gson().fromJson<Parking>(readText,
                object : TypeToken<Parking>(){}.type
                )
            gsonData.parkingLots.forEach {
                info(" message : ${it.address} , ${it.parkName} , ${it.introduction}")
            }
            nowDat = Parking(arrayListOf())

            for (i in 0..9){

                nowDat.parkingLots.add(gsonData.parkingLots[i])

            }


            uiThread {

                result.text = "搜尋筆數有 : ${gsonData.parkingLots.size} 筆"

                parkingRecycle.run {
                    this.setHasFixedSize(true)
                    mLayoutManager = LinearLayoutManager(this@OpenDataActivity)
                    this.layoutManager = mLayoutManager
                    mAdapter = ParkingAdapter()
                    this.adapter =mAdapter
                    this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                            super.onScrolled(recyclerView, dx, dy)
                            info("onScrolled")
                        }
                        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                            super.onScrollStateChanged(recyclerView, newState)
                            if (mLayoutManager.findLastCompletelyVisibleItemPosition() == nowDat.parkingLots.size-1){
                                info { "onScrollStateChanged " }
                                loadmore()

                            }
                            // info("find "+mLayoutManager.findLastCompletelyVisibleItemPosition())
                        }
                    })

                }






            }


        }



    }

    private fun loadmore() {
        info("add before ${nowDat.parkingLots.size}")
        if (nowDat.parkingLots.size + RELOAD_COUNT < gsonData.parkingLots.size){
            for (i in nowDat.parkingLots.size until nowDat.parkingLots.size+RELOAD_COUNT){
                nowDat.parkingLots.add(gsonData.parkingLots[i])
            }
        }else{
            for (i in nowDat.parkingLots.size until gsonData.parkingLots.size){
                nowDat.parkingLots.add(gsonData.parkingLots[i])
            }
        }
        mAdapter.notifyDataSetChanged()
        info("add after ${nowDat.parkingLots.size}")


    }

    inner class ParkingAdapter : RecyclerView.Adapter<ParkingViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkingViewHolder {
            return ParkingViewHolder(layoutInflater.inflate(R.layout.parkinglot_row,parent,false))
        }

        override fun getItemCount() = nowDat.parkingLots.size

        override fun onBindViewHolder(holder: ParkingViewHolder, position: Int) {
            holder.name.text = "Position : ${position+1}  "+nowDat.parkingLots[position].parkName
            holder.address.text = nowDat.parkingLots[position].address
            holder.itemView.tag = position
        }


    }

    inner class ParkingViewHolder(view: View) : RecyclerView.ViewHolder(view){
           val name = view.lotsName!!
           val address: TextView = view.lotsAddress!!
    }

}



data class Parking(
    val parkingLots: MutableList<ParkingLot>
)

data class ParkingLot(
    val address: String,
    val areaId: String,
    val areaName: String,
    val introduction: String,
    val parkId: String,
    val parkName: String,
    val payGuide: String,
    val surplusSpace: String,
    val totalSpace: Int,
    val wgsX: Double,
    val wgsY: Double
)
