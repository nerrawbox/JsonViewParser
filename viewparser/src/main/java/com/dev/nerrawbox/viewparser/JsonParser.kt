package com.dev.nerrawbox.viewparser

import android.content.Context
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.nio.charset.Charset


/**
 * @param mContext -> Refers to the current Context Activity of a view
 * @param mFileName -> The file name of the target json file inside the assets folder
 * @param mJSONRoot -> The Key for the json data you want to get and parse
 *
 * This class takes the json file from the assets folder on your Android Studio project,
 * provided the file name of the desired json file.
 *
 * -Warren Cedro 1/9/19
 */
internal class JsonParser(private val mContext: Context, private val mFileName: String, private val mJSONRoot: String) {

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

    /**
     * This function searches the value from the json file by their key
     * i.e. LAYOUT_INFO declared inside Constants.kt
     *
     * Note: Revise this function as the json file requires
     */
    fun getLayoutInfoFromJson(): JSONArray {

        val jsonLayout = JSONObject(loadJSONFromAsset())
            .getJSONArray(mJSONRoot)
            .getJSONObject(0)
            .getJSONArray(LAYOUT_INFO)

        Log.d("jsonLayout", jsonLayout.toString())

        return jsonLayout
    }

    /**
     * This function searches the value from the json file by their key
     * i.e. VIEW_WIDGETS declared inside Constants.kt
     *
     * Note: Revise this function as the json file requires
     */
    fun getWidgetInfoFromJson(): JSONArray {

        val jsonWidgets = JSONObject(loadJSONFromAsset())
                    .getJSONArray(mJSONRoot)
                    .getJSONObject(0)
                    .getJSONArray(VIEW_WIDGETS)

        Log.d("jsonWidgets", jsonWidgets.toString())

        return jsonWidgets

    }

}