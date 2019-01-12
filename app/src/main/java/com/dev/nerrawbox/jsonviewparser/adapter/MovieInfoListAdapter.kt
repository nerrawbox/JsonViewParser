package com.dev.nerrawbox.jsonviewparser.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.dev.nerrawbox.jsonviewparser.model.MovieInfo

import com.dev.nerrawbox.jsonviewparser.R

class MovieInfoListAdapter(context: Context, resource: Int, objects: List<MovieInfo>?) :
    ArrayAdapter<MovieInfo>(context, resource, objects) {

    private val mContext: Context by lazy { context }
    private val mResource: Int by lazy { resource }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val title = getItem(position)!!.title
        val director = getItem(position)!!.director

//        Log.d("Wrn", "Adapter: Title =  $title")
//        Log.d("Wrn", "Adapter: Director =  $director")

        var listItem = convertView

        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(mResource, parent, false)

        val txtTitle = listItem?.findViewById(R.id.txtTitle) as TextView
        val txtDirector = listItem?.findViewById(R.id.txtDirector) as TextView

        txtTitle.text = title
        txtDirector.text = director

        return listItem
    }
}