package com.dev.nerrawbox.jsonviewparser.model

class GenericDataManager<T>(model: T?) {

    private val mModel = model
    private var mList = ArrayList<T>()

    fun setMyGenericList() { mList.add(mModel!!) }

    fun getGenericList(): ArrayList<T> = mList

}