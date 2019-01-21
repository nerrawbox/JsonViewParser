package com.dev.nerrawbox.jsonviewparser.model

import com.dev.nerrawbox.jsonviewparser.model.IDataManager.*
import java.io.Serializable

data class Movie(override var title: String,
                 override var director: String,
                 override var description: String,
                 override var producer: String,
                 override var releaseDate: String,
                 override var rtScore: String) : IMovie, Serializable

data class People(override var name: String,
                  override var gender: String,
                  override var age: String,
                  override var eyeColor: String,
                  override var hairColor: String) : IPeople, Serializable