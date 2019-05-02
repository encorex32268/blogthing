package com.lee.testloadopendata

fun main() {

    val datas = mutableListOf<String>()
    for (i in 1..18) {
        datas.add("user $i")
    }

    var newData = mutableListOf<String>()

    val RELOADCOUNT = 9

    if (newData.size + RELOADCOUNT < datas.size){
        for (i in newData.size..newData.size+RELOADCOUNT) {
            newData.add(datas[i])
        }
    }
    println("")
    println("datas -> ")
    datas.forEach {
        print(" $it ,")
    }
    println("newData -> ")
    newData.forEach {
        print(" $it ,")
    }
    if (newData.size + RELOADCOUNT < datas.size){
        for (i in newData.size until newData.size+RELOADCOUNT) {
            newData.add(datas[i])
        }
    }else{
        for (i in newData.size until datas.size) {
            newData.add(datas[i])
        }
    }
    println("")
    println("datas -> ")
    datas.forEach {
        print(" $it ,")
    }
    println("newData -> ")
    newData.forEach {
        print(" $it ,")
    }
}