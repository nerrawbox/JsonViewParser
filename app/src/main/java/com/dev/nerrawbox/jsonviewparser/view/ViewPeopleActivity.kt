package com.dev.nerrawbox.jsonviewparser.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dev.nerrawbox.jsonviewparser.R
import com.dev.nerrawbox.jsonviewparser.model.dataManager.IDataManager

class ViewPeopleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_people)

        val txtName: TextView = findViewById(R.id.txtName)
        val txtGender: TextView = findViewById(R.id.txtGender)
        val txtAge: TextView = findViewById(R.id.txtAge)
        val txtEyeColor: TextView = findViewById(R.id.txtEyeColor)
        val txtHairColor: TextView = findViewById(R.id.txtHairColor)

        if(intent != null){
            @Suppress("UNCHECKED_CAST")
            val peopleInfo = intent.extras.get("peopleInfo")
                    as IDataManager.IDataClassManager<IDataManager.IPeople>

            txtName.text = peopleInfo.getDetail().name
            txtGender.text = peopleInfo.getDetail().gender
            txtAge.text = peopleInfo.getDetail().age
            txtEyeColor.text = peopleInfo.getDetail().eyeColor
            txtHairColor.text = peopleInfo.getDetail().hairColor

        }
    }
}
