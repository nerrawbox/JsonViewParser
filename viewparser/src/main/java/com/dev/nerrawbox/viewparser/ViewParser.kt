package com.dev.nerrawbox.viewparser

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class ViewParser(val mContext: Context, private val mLinearLayout: LinearLayout, val mFileName: String, val mJSONRoot: String){

    private var layoutParams: LinearLayout.LayoutParams? = null
    private var childLayout: LinearLayout? = null

    fun initViews(mJSONArrayKey: String): List<View> {

        var views = ArrayList<View>()

        when(mJSONArrayKey) {
            "layout_info" -> return emptyList()
            "view_widgets" ->  views = initWidgets(mJSONArrayKey)
        }

//        mLinearLayout.addView(childLayout)

        return views
    }


    private fun initWidgets(jsonArrayKey: String): ArrayList<View> {
        val jsonParser = JsonParser(mContext, mFileName, jsonArrayKey)
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
        b1.layoutParams = layoutParams
        childLayout?.addView(b1)

        return b1
    }

    private fun drawTextView(): TextView {
        val t1 = TextView(mContext)
        t1.text = "Text View"
        t1.layoutParams = layoutParams
        t1.visibility = View.VISIBLE
        childLayout?.addView(t1)

        return t1
    }

    private fun drawEditText(): EditText {

        val e1 = EditText(mContext)
        e1.hint = "Enter Text"
        e1.layoutParams = layoutParams
        e1.visibility = View.VISIBLE
        childLayout?.addView(e1)

        return e1
    }

}