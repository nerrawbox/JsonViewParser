package com.dev.nerrawbox.viewparser

import android.content.Context
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.nio.charset.Charset

internal class JsonParser(val mContext: Context, val mFileName: String, val mJSONRoot: String) {

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

    //Note: Revise this function as the json file requires
    fun getLayoutInfoFromJson(): JSONArray {

        val jsonLayout = JSONObject(loadJSONFromAsset())
            .getJSONArray(mJSONRoot)
            .getJSONObject(0)
            .getJSONArray(LAYOUT_INFO)

        Log.d("jsonLayout", jsonLayout.toString())

        return jsonLayout
    }

    //Note: Revise this function as the json file requires
    fun getWidgetInfoFromJson(): JSONArray {

        val jsonWidgets = JSONObject(loadJSONFromAsset())
                    .getJSONArray(mJSONRoot)
                    .getJSONObject(0)
                    .getJSONArray(VIEW_WIDGETS)

        Log.d("jsonWidgets", jsonWidgets.toString())

        return jsonWidgets

    }

}