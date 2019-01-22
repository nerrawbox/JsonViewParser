package com.dev.nerrawbox.jsonviewparser.model.dataManager

import com.dev.nerrawbox.jsonviewparser.model.dataManager.IDataManager.*
import java.io.Serializable

data class Movie(override var title: String, override var director: String, override var description: String,
                 override var producer: String, override var releaseDate: String, override var rtScore: String)
    : IMovie, IDataClassManager<IMovie>, Serializable {

    override fun getDetail(): IMovie {
        val iMovie = this@Movie as IMovie

        return iMovie
    }
}

data class People(override var name: String, override var gender: String, override var age: String,
                  override var eyeColor: String, override var hairColor: String)
    : IPeople, IDataClassManager<IPeople>, Serializable {

    override fun getDetail(): IPeople {
        val iPeople = this@People as IPeople

        return iPeople
    }

}