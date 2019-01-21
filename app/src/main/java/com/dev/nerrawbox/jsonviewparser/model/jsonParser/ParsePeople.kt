package com.dev.nerrawbox.jsonviewparser.model.jsonParser

import android.content.Context
import com.dev.nerrawbox.jsonviewparser.model.dataManager.GenericDataManager
import com.dev.nerrawbox.jsonviewparser.model.dataManager.People
import org.json.JSONArray
import java.nio.charset.Charset

class ParsePeople(private val mContext: Context,
                  val result: (ArrayList<People>) -> Unit,
                  val error: (String) -> Unit) : IJsonParser {

    override fun parseJson() {
        val genericDataManager by lazy { GenericDataManager<People>() }
        try {
            val jsonArr = JSONArray(fetchJson())

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
        } catch (ex: Exception) {
            error(ex.message!!)
        }
        result(genericDataManager.getGenericList())
    }

    override fun fetchJson(): String {
        lateinit var json: String
        try {
            val inputStream = mContext.assets.open("peopleInfo.json")
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