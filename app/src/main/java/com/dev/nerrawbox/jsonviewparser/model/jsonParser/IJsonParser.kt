package com.dev.nerrawbox.jsonviewparser.model.jsonParser

interface IJsonParser {

    fun parseJson()

    fun fetchJson() : String

    interface IJsonParserResult<T>{

        fun getResultList() : ArrayList<T>
    }

}