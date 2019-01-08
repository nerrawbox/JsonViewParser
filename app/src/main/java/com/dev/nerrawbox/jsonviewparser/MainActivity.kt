package com.dev.nerrawbox.jsonviewparser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.dev.nerrawbox.viewparser.ViewParser
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var myWidgets: List<View>? = null
    private var myTextView: TextView? = null
    private var myEditText: EditText? = null
    private var myBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}
