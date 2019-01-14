package com.dev.nerrawbox.jsonviewparser.model

import java.io.Serializable

data class MovieInfo(var title: String, var director: String, var description: String,
                     var producer: String, var release_date: String, var rt_score: String) : Serializable