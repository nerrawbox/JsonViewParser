package com.dev.nerrawbox.jsonviewparser.model.dataManager

import com.dev.nerrawbox.jsonviewparser.model.dataManager.IDataManager.*
import java.io.Serializable

data class Movie(override var title: String, override var director: String, override var description: String,
                 override var producer: String, override var releaseDate: String, override var rtScore: String)
    : IMovie, IDataClassManager, Serializable {

    override fun getDetail1() : String = title

    override fun getDetail2(): String = director

    override fun getDetail3(): String = description

    override fun getDetail4(): String = producer

    override fun getDetail5(): String = releaseDate

    override fun getDetail6(): String = rtScore
}

data class People(override var name: String, override var gender: String, override var age: String,
                  override var eyeColor: String, override var hairColor: String)
    : IPeople, IDataClassManager, Serializable {

    override fun getDetail1(): String = name

    override fun getDetail2(): String = gender

    override fun getDetail3(): String = age

    override fun getDetail4(): String = eyeColor

    override fun getDetail5(): String = hairColor
}