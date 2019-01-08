package com.dev.nerrawbox.viewparser

import android.content.Context
import com.beust.klaxon.JsonObject
import org.json.JSONArray
import org.json.JSONObject
import java.nio.charset.Charset

class JsonParser(val mContext: Context, val mFileName: String, val mJSONRoot: String) {

    private fun loadJSONFromAsset(): String? {
        var json: String? = null
        try {
            val inputStream = mContext.assets.open(mFileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = buffer.toString(Charset.defaultCharset())
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return json


    }

    fun getLayoutInfoFromJson(): String {

        return ""
    }

    fun getWidgetInfoFromJson(): JSONArray {


        return JSONArray("")
    }


}