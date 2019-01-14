package com.dev.nerrawbox.jsonviewparser.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.dev.nerrawbox.jsonviewparser.R
import com.dev.nerrawbox.jsonviewparser.ViewPeopleActivity
import com.dev.nerrawbox.jsonviewparser.model.People
import java.io.Serializable

class PeopleListAdapter(context: Context, resource: Int, objects: List<People>?) :
    ArrayAdapter<People>(context, resource, objects) {

    private val mContext by lazy { context }
    private val mResource by lazy { resource }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val name = getItem(position)!!.name
        val gender = getItem(position)!!.gender
        val age = getItem(position)!!.age
        val eyeColor = getItem(position)!!.eye_color
        val hairColor = getItem(position)!!.hair_color

        var listItem = convertView

        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(mResource, parent, false)

        val peopleInfo = People(name, gender, age, eyeColor, hairColor)

        val txtName = listItem?.findViewById(R.id.txtForTitleOrName) as TextView
        val txtGender = listItem.findViewById(R.id.txtForDirectorOrGender) as TextView
        val btnViewPeople = listItem.findViewById(R.id.btnViewMovOrPeople) as ImageButton

        txtName.text = peopleInfo.name
        txtGender.text = peopleInfo.gender

        btnViewPeople.setOnClickListener {
            val intent = Intent(mContext, ViewPeopleActivity::class.java)
            intent.putExtra("peopleInfo", peopleInfo as Serializable)
            mContext.startActivity(intent)
        }

        return listItem
    }
}