package com.dev.nerrawbox.jsonviewparser.model.jsonParser

import android.content.Context
import com.dev.nerrawbox.jsonviewparser.model.dataManager.GenericDataManager
import com.dev.nerrawbox.jsonviewparser.model.dataManager.Movie
import org.json.JSONArray
import java.nio.charset.Charset
import kotlin.collections.ArrayList

class ParseMovie(private val mContext: Context) : IJsonParser, IJsonParser.IJsonParserResult<Movie>{

    private val genericDataManager by lazy { GenericDataManager<Movie>() }

    override fun getResultList() : ArrayList<Movie> {
        parseJson()
        return genericDataManager.getGenericList()
    }

    override fun parseJson() {
        try {
            val jsonArr = JSONArray(fetchJson())
            val len = jsonArr.length() -1

            (0..len).forEach { index ->
                val jsonObject = jsonArr.getJSONObject(index)

                val title = jsonObject.getString("title")
                val director = jsonObject.getString("director")
                val description = jsonObject.getString("description")
                val producer = jsonObject.getString("producer")
                val releaseDate = jsonObject.getString("release_date")
                val rtScore = jsonObject.getString("rt_score")

                val movie = Movie( title, director, description, producer, releaseDate, rtScore)

                genericDataManager.setMyGenericList(movie)
            }
        } catch (ex: Exception) {
            error(ex.message!!)
        }
    }

    override fun fetchJson() : String {
        lateinit var json: String
        try {
            val inputStream = mContext.assets.open("movieInfo.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = buffer.toString(Charset.defaultCharset())
        } catch (ex: Exception) {
            error(ex.message!!)
        }
        return json
    }

}