package com.dev.nerrawbox.viewparser

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import org.json.JSONObject

class ViewParser(val mContext: Context, private val mLinearLayout: LinearLayout, val mFileName: String, val mJSONRoot: String){

    private val jsonParser by lazy { JsonParser(mContext, mFileName, mJSONRoot) }
    private var layoutParams: LinearLayout.LayoutParams? = null
    private var childLayout : LinearLayout? = null

    fun initViews(): List<View> {

        initLayout()

        val views = initWidgets()

        mLinearLayout.addView(childLayout)

        return views
    }

    private fun initLayout(){
        val layoutObject = jsonParser.getLayoutInfoFromJson().getJSONObject(0)

        if(layoutObject.has(LAYOUT_ID))
           initLinearLayout(layoutObject)
        if(layoutObject.has(LAYOUT_ORIENTATION))
            initOrientation(layoutObject)
        if(layoutObject.has(LAYOUT_PARAMS))
            initParams(layoutObject)

    }

    private fun initParams(layoutObject: JSONObject) {
        val w = layoutObject.getJSONObject(LAYOUT_PARAMS).getString(LAYOUT_PARAMS_WIDTH)
        val h = layoutObject.getJSONObject(LAYOUT_PARAMS).getString(LAYOUT_PARAMS_HEIGHT)

        val paramW = if(w == "match_parent") LinearLayout.LayoutParams.MATCH_PARENT else LinearLayout.LayoutParams.WRAP_CONTENT
        val paramH = if(h == "match_parent") LinearLayout.LayoutParams.MATCH_PARENT else LinearLayout.LayoutParams.WRAP_CONTENT

        layoutParams = LinearLayout.LayoutParams(paramW, paramH)
    }

    private fun initOrientation(layoutObject: JSONObject) {
        when(layoutObject.getString(LAYOUT_ORIENTATION)){
            "vertical" -> childLayout?.orientation = LinearLayout.VERTICAL
            "horizontal" -> childLayout?.orientation = LinearLayout.HORIZONTAL
        }
    }

    private fun initLinearLayout(layoutObject: JSONObject) {
        when(layoutObject.getString(LAYOUT_ID)){
            "linear_layout" -> childLayout = LinearLayout(mContext)
            //TODO: Add condition for different layout types e.g. RelativeLayout
        }
    }


    private fun initWidgets(): ArrayList<View> {

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

    private fun drawButton(): Button {
        val b1 = Button(mContext)
        b1.text = "Button"
        //b1.layoutParams = layoutParams
        childLayout?.addView(b1)

        return b1
    }

    private fun drawTextView(): TextView {
        val t1 = TextView(mContext)
        t1.text = "Text View"
        //t1.layoutParams = layoutParams
        t1.visibility = View.VISIBLE
        childLayout?.addView(t1)

        return t1
    }

    private fun drawEditText(): EditText {

        val e1 = EditText(mContext)
        e1.hint = "Enter Text"
        //e1.layoutParams = layoutParams
        e1.visibility = View.VISIBLE
        childLayout?.addView(e1)

        return e1
    }

}