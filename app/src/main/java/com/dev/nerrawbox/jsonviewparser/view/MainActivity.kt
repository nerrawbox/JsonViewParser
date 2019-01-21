package com.dev.nerrawbox.jsonviewparser.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*
import com.dev.nerrawbox.jsonviewparser.R
import com.dev.nerrawbox.viewparser.ViewParser

/**
 * TestApp for the framework
 */
class MainActivity : AppCompatActivity() {

    private var myWidgets: List<View>? = null
    private var myTextView1: TextView? = null
    private var myEditText1: EditText? = null
    private var myTextView2: TextView? = null
    private var myEditText2: EditText? = null
    private var myBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgView: ImageView = findViewById(R.id.imgView)
        imgView.setOnClickListener {
            setupParser()
            Toast.makeText(this@MainActivity, "JsonParser Activated", Toast.LENGTH_SHORT).show()
        }

        val txtView: TextView = findViewById(R.id.txtView)
        txtView.setOnClickListener {
            setupParser()
            Toast.makeText(this@MainActivity, "JsonParser Activated", Toast.LENGTH_SHORT).show()
        }


        val lvCategory: ListView = findViewById(R.id.lvCategory)

        val category = listOf("Movie", "People")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, category)

        lvCategory.adapter = adapter

        val intent = Intent(this, ExerciseActivity::class.java)
        lvCategory.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as String

            if(selectedItem == category[0])
                intent.putExtra("list_type", "movie")
            else if(selectedItem == category[1])
                intent.putExtra("list_type", "people")

            startActivity(intent)
        }

    }

    private fun setupParser(){
        val parentLayout: LinearLayout = findViewById(R.id.myLinearLayout)
        val viewParser = ViewParser(this, "screen.json", "MainActivity")

        val childLayout = viewParser.initLayout()
        childLayout?.removeAllViews()
        parentLayout.addView(childLayout)

        childLayout?.setPadding(24, 24, 24, 0)

        myWidgets = viewParser.initViews()
        myTextView1 = myWidgets!![0] as TextView
        myEditText1 = myWidgets!![1] as EditText
        myTextView2 = myWidgets!![2] as TextView
        myEditText2 = myWidgets!![3] as EditText
        myBtn = myWidgets!![4] as Button

        myTextView1?.text = "Email"
        myEditText1?.hint = "Enter Email"

        myTextView2?.text = "Password"
        myEditText2?.hint = "Password"
        myEditText2?.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        myBtn?.text = "Login"
        myBtn?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
