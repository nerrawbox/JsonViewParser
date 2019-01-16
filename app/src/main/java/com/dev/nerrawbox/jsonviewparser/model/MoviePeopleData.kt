package com.dev.nerrawbox.jsonviewparser.model

import java.io.Serializable

data class MovieInfo(var title: String, var director: String, var description: String,
                     var producer: String, var release_date: String, var rt_score: String) : Serializable

data class People(var name: String, var gender: String, var age: String,
                  var eye_color: String, var hair_color: String) : Serializable