package com.dev.nerrawbox.jsonviewparser.model

import org.json.JSONObject

object DataManager {

    val movieList = ArrayList<MovieInfo>()
    val peopleList = ArrayList<People>()

    fun initializeMovie(jsonObject: JSONObject) {

            val title = jsonObject.getString("title")
            val director = jsonObject.getString("director")
            val description = jsonObject.getString("description")
            val producer = jsonObject.getString("producer")
            val releaseDate = jsonObject.getString("release_date")
            val rtScore = jsonObject.getString("rt_score")

            val movie = MovieInfo(title, director, description, producer, releaseDate, rtScore)

            movieList.add(movie)
    }

    fun initializePeople(jsonObject: JSONObject) {

            val name = jsonObject.getString("name")
            val gender = jsonObject.getString("gender")
            val age = jsonObject.getString("age")
            val eyeColor = jsonObject.getString("eye_color")
            val hairColor = jsonObject.getString("hair_color")

            val person = People(name, gender, age, eyeColor, hairColor)

            peopleList.add(person)
    }

    fun findPeople(index: Int) : People = peopleList[index]

    fun findMovie(index: Int) : MovieInfo = movieList[index]
}