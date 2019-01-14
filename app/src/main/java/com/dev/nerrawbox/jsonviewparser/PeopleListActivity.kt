package com.dev.nerrawbox.jsonviewparser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dev.nerrawbox.jsonviewparser.model.People

class PeopleListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_list)

        val txtName: TextView = findViewById(R.id.txtName)
        val txtGender: TextView = findViewById(R.id.txtGender)
        val txtAge: TextView = findViewById(R.id.txtAge)
        val txtEyeColor: TextView = findViewById(R.id.txtEyeColor)
        val txtHairColor: TextView = findViewById(R.id.txtHairColor)

        if(intent != null){
            val peopleInfo = intent.extras.get("peopleInfo") as People

            txtName.text = peopleInfo.name
            txtGender.text = peopleInfo.gender
            txtAge.text = peopleInfo.age
            txtEyeColor.text = peopleInfo.eye_color
            txtHairColor.text = peopleInfo.hair_color

        }
    }
}
