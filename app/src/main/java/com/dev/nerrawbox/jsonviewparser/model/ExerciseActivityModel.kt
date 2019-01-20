package com.dev.nerrawbox.jsonviewparser.model

import android.content.Context
import android.util.Log
import com.dev.nerrawbox.jsonviewparser.adapter.MovieListAdapter
import com.dev.nerrawbox.jsonviewparser.adapter.PeopleListAdapter
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract
import org.json.JSONArray
import java.nio.charset.Charset

class ExerciseActivityModel(context: Context) : IExerciseActivityContract.IModelContract {

    private val mContext = context

    override fun parseJsonSetMovieAdapter(mResource: Int): MovieListAdapter {
        Log.d("Wrn", "parseJsonSetMovieAdapter")
        return MovieListAdapter(mContext, mResource, parseJsonMovieData())
    }

    override fun parseJsonSetPeopleAdapter(mResource: Int): PeopleListAdapter {
        Log.d("Wrn", "parseJsonSetPeopleAdapter")
        return PeopleListAdapter(mContext, mResource, parseJsonPeopleData())
    }

    private fun parseJsonMovieData(): ArrayList<Movie> {
        Log.d("Wrn", "parseJsonMovieData")
        var movInfoList = ArrayList<Movie>()
        val genericDataManager = GenericDataManager<Movie>()
        try {
            val jsonArr = JSONArray(loadJSONFromAsset("movieInfo.json"))

            val len = jsonArr.length() -1

            (0..len).forEach { index ->
                val jsonObject = jsonArr.getJSONObject(index)

                val title = jsonObject.getString("title")
                val director = jsonObject.getString("director")
                val description = jsonObject.getString("description")
                val producer = jsonObject.getString("producer")
                val releaseDate = jsonObject.getString("release_date")
                val rtScore = jsonObject.getString("rt_score")

                val movie = Movie(title, director, description, producer, releaseDate, rtScore)

                genericDataManager.setMyGenericList(movie)
            }
            movInfoList = genericDataManager.getGenericList()

        } catch (ex: Exception) {
            Log.d("Wrn-pJson-ex", ex.message)
        }

        return movInfoList
    }

    private fun parseJsonPeopleData(): ArrayList<People> {
        Log.d("Wrn", "parseJsonPeopleData")
        var pplInfoList = ArrayList<People>()
        val genericDataManager = GenericDataManager<People>()
        try {
            val jsonArr = JSONArray(loadJSONFromAsset("peopleInfo.json"))

            val len = jsonArr.length() -1

            (0..len).forEach { index ->
                val jsonObject = jsonArr.getJSONObject(index)

                val name = jsonObject.getString("name")
                val gender = jsonObject.getString("gender")
                val age = jsonObject.getString("age")
                val eyeColor = jsonObject.getString("eye_color")
                val hairColor = jsonObject.getString("hair_color")

                val person = People(name, gender, age, eyeColor, hairColor)

                genericDataManager.setMyGenericList(person)
            }
            pplInfoList = genericDataManager.getGenericList()
        } catch (ex: Exception) {
            Log.d("Wrn-pJson-ex", ex.message)
        }
        return pplInfoList
    }

    private fun loadJSONFromAsset(fileName: String): String {
        Log.d("Wrn", "loadJSONFromAsset")
        lateinit var json: String
        try {
            val inputStream = mContext.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = buffer.toString(Charset.defaultCharset())
        } catch (ex: Exception) {
            Log.d("Wrn-lJson-ex", ex.message)
        }
        //Log.d("Wrn-json", json)
        return json
    }
}