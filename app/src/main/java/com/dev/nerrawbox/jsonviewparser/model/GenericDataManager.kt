package com.dev.nerrawbox.jsonviewparser.model


class GenericDataManager<T> {
    private var mList = ArrayList<T>()

    fun setMyGenericList(model: T) {
        mList.add(model)
    }

    fun getGenericList(): ArrayList<T> = mList

}