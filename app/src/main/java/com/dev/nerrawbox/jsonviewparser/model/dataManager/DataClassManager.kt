package com.dev.nerrawbox.jsonviewparser.model.dataManager

import java.io.Serializable

data class Movie(var title: String, var director: String, var description: String,
                 var producer: String, var releaseDate: String, var rtScore: String)
    : ViewActivityInterface, Serializable {

    override fun getDetail1(): String { return title }
    override fun getDetail2(): String { return director }
    override fun getDetail3(): String { return description }
    override fun getDetail4(): String { return producer }
    override fun getDetail5(): String { return rtScore }

    override fun getLabel2(): String { return "Director" }
    override fun getLabel3(): String { return "Producer" }
    override fun getLabel4(): String { return "Released Date" }
    override fun getLabel5(): String { return "Score" }

}

data class People(var name: String,var gender: String,var age: String,
                  var eyeColor: String, var hairColor: String)
    : ViewActivityInterface, Serializable {

    override fun getDetail1(): String { return name }
    override fun getDetail2(): String { return gender }
    override fun getDetail3(): String { return age }
    override fun getDetail4(): String { return eyeColor }
    override fun getDetail5(): String { return hairColor }

    override fun getLabel2(): String { return "gender" }
    override fun getLabel3(): String { return "age" }
    override fun getLabel4(): String { return "eye color" }
    override fun getLabel5(): String { return "hair color" }
}