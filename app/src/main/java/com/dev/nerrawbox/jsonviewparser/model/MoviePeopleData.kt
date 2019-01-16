package com.dev.nerrawbox.jsonviewparser.model


data class MovieInfo(var title: String, var director: String, var description: String,
                     var producer: String, var release_date: String, var rt_score: String)

data class People(var name: String, var gender: String, var age: String,
                  var eye_color: String, var hair_color: String)