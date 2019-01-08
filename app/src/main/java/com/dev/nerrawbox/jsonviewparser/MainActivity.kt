package com.dev.nerrawbox.jsonviewparser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.dev.nerrawbox.viewparser.ViewParser

class MainActivity : AppCompatActivity() {

    private var myWidgets: List<View>? = null
    private var myTextView: TextView? = null
    private var myEditText: EditText? = null
    private var myBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val parentLayout: LinearLayout = findViewById(R.id.myLinearLayout)
        val viewParser = ViewParser(this, parentLayout, "screen.json", "MainActivity")

        myWidgets = viewParser.initViews()
        myTextView = myWidgets!![0] as TextView
        myEditText = myWidgets!![1] as EditText
        myBtn = myWidgets!![2] as Button

        myTextView?.text = "Hello World"
        myEditText?.hint = "Username"

        myBtn?.text = "Submit"
        myBtn?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Clicked", Toast.LENGTH_SHORT).show()
        }

    }
}
