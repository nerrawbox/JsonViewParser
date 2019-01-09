package com.dev.nerrawbox.viewparser

import android.content.Context
import android.view.View
import android.widget.*
import org.json.JSONObject

/**
 * @param mContext -> Refers to the current Context Activity of a view
 * @param mFileName -> The file name of the target json file inside the assets folder, will be passed to JsonParser
 * @param mJSONRoot -> The Key for the json data you want to get and parse, will be passed to JsonParser
 *
 * Note: This Module assumes that the developers has the same format of the json file provided in this example.
 * Note: JsonParser will be revised according to the actual structure of the json file.
 * -Warren Cedro 1/9/19
 */
class ViewParser(private val mContext: Context, private val mFileName: String, private val mJSONRoot: String){

    /**
     * @val jsonParser -> Instance object for the JsonParser class.
     * @var childLayout -> Will hold the views (i.e. Button, TextView, ...) parse from the json file
     *
     */
    private val jsonParser by lazy { JsonParser(mContext, mFileName, mJSONRoot) }
    private var childLayout : LinearLayout? = null

    /**
     * This function gets the information of the Layout from the json file
     * Tests the returned JSONObject if it has the following data declared inside the Constants.ks
     * When the test succeeds call the setup functions (e.g. setupLinearLayout(), ...)
     * Then returns the Layout e.g. LinearLayout
     */
    fun initLayout(): LinearLayout? {
        val layoutObject = jsonParser.getLayoutInfoFromJson().getJSONObject(0)

        if(layoutObject.has(LAYOUT_ID))
            setupLinearLayout(layoutObject)
        if(layoutObject.has(LAYOUT_ORIENTATION))
            setupOrientation(layoutObject)
        if(layoutObject.has(LAYOUT_PARAMS))
            setupParams(layoutObject)

        return childLayout
    }

    /**
     * This function gets the information of the Views (i.e. Button, TextView, ...) from the json file
     * Then loops fromm the JSONArray and calls the draw functions (e.g. drawButton(), ...) accordingly
     * Then returns the View as List. @param List<View>
     */
    fun initViews(): List<View> {

        val viewIds = jsonParser.getWidgetInfoFromJson()
        val views = ArrayList<View>()

        for (i in 0 until viewIds.length()) {
            when (viewIds[i]) {
                "text_view" -> views.add(drawTextView())
                "edit_text" -> views.add(drawEditText())
                "button" -> views.add(drawButton())
            }
        }
        return views
    }

    //Setup Functions
    private fun setupLinearLayout(layoutObject: JSONObject) {
        when(layoutObject.getString(LAYOUT_ID)){
            "linear_layout" -> childLayout = LinearLayout(mContext)
            //Note: Add condition for different layout types e.g. RelativeLayout
        }
    }

    private fun setupParams(layoutObject: JSONObject) {
        val w = layoutObject.getJSONObject(LAYOUT_PARAMS).getString(LAYOUT_PARAMS_WIDTH)
        val h = layoutObject.getJSONObject(LAYOUT_PARAMS).getString(LAYOUT_PARAMS_HEIGHT)

        val paramW = if(w == "match_parent") LinearLayout.LayoutParams.MATCH_PARENT else LinearLayout.LayoutParams.WRAP_CONTENT
        val paramH = if(h == "match_parent") LinearLayout.LayoutParams.MATCH_PARENT else LinearLayout.LayoutParams.WRAP_CONTENT

        val layoutParams = LinearLayout.LayoutParams(paramW, paramH)
        childLayout?.layoutParams = layoutParams
    }

    private fun setupOrientation(layoutObject: JSONObject) {
        when(layoutObject.getString(LAYOUT_ORIENTATION)){
            "vertical" -> childLayout?.orientation = LinearLayout.VERTICAL
            "horizontal" -> childLayout?.orientation = LinearLayout.HORIZONTAL
        }
    }

    //Draw Functions
    private fun drawButton(): Button {
        val b1 = Button(mContext)
        b1.text = "Button"
        childLayout?.addView(b1)

        return b1
    }

    private fun drawTextView(): TextView {
        val t1 = TextView(mContext)
        t1.text = "TextView"
        t1.visibility = View.VISIBLE
        childLayout?.addView(t1)

        return t1
    }

    private fun drawEditText(): EditText {
        val e1 = EditText(mContext)
        e1.hint = "EditText"
        e1.visibility = View.VISIBLE
        childLayout?.addView(e1)

        return e1
    }

}