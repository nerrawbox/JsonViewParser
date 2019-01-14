package com.dev.nerrawbox.jsonviewparser.model

import android.content.Context
import android.util.Log
import com.dev.nerrawbox.jsonviewparser.adapter.MovieInfoListAdapter
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract
import org.json.JSONArray
import java.nio.charset.Charset
import java.io.*
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class ExerciseActivityModel(context: Context) : IExerciseActivityContract.IModelContract {

    private val mContext = context

    override fun parseJsonSetAdapter(mResource: Int): MovieInfoListAdapter {
        Log.d("Wrn", "parseJsonSetAdapter")
        return MovieInfoListAdapter(mContext, mResource, parseJsonData())
    }

    private fun parseJsonData(): ArrayList<MovieInfo> {
        Log.d("Wrn", "parseJsonData")
        val movInfoList = ArrayList<MovieInfo>()
        try {
            val jsonArr = JSONArray(loadJSONFromAsset())

            val len = jsonArr.length() -1

            (0..len).forEach { index ->
                val jsonObject = jsonArr.getJSONObject(index)

                val title = jsonObject.getString("title")
                val director = jsonObject.getString("director")
                val description = jsonObject.getString("description")
                val producer = jsonObject.getString("producer")
                val releaseDate = jsonObject.getString("release_date")
                val rtScore = jsonObject.getString("rt_score")

                val movInfo = MovieInfo(title, director, description, producer, releaseDate, rtScore)

                movInfoList.add(movInfo)
            }
        } catch (ex: Exception) {
            Log.d("Wrn-pJson-ex", ex.message)
        }
        return movInfoList
    }

    private fun loadJSONFromAsset(): String {
        Log.d("Wrn", "loadJSONFromAsset")
        lateinit var json: String
        try {
            val inputStream = mContext.assets.open("movieInfo.json")
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

    private fun loadJSONFromHTTP(): String {
        try {
            val url = URL("https://ghibliapi.herokuapp.com/films")
            val con = url.openConnection() as HttpURLConnection

            //CON PROPS
            con.requestMethod = "GET"
            con.connectTimeout = 15000
            con.readTimeout = 15000
            con.doInput = true

            if (con.responseCode == 200) {
                //GET INPUT FROM STREAM
                val inputStream = BufferedInputStream(con.inputStream)
                val bufferedReader = BufferedReader(InputStreamReader(inputStream))

                val jsonData = StringBuffer()
                var line: String?

                do {
                    line = bufferedReader.readLine()

                    if (line == null){ break}

                    jsonData.append(line + "\n")

                } while (true)

                //CLOSE RESOURCES
                bufferedReader.close()
                inputStream.close()

                //RETURN JSON
                return jsonData.toString()

            } else {
                return "Error " + con.responseMessage
            }
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            return "URL ERROR " + e.message

        } catch (e: IOException) {
            e.printStackTrace()
            return "CONNECT ERROR " + e.message
        }
    }
}