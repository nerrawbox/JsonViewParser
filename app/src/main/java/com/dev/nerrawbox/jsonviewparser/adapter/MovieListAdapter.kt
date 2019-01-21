package com.dev.nerrawbox.jsonviewparser.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.dev.nerrawbox.jsonviewparser.model.dataManager.Movie

import com.dev.nerrawbox.jsonviewparser.R
import com.dev.nerrawbox.jsonviewparser.ViewMovieActivity
import java.io.Serializable

class MovieListAdapter(context: Context, resource: Int, objects: List<Movie>?) :
    ArrayAdapter<Movie>(context, resource, objects) {

    private val mContext: Context by lazy { context }
    private val mResource: Int by lazy { resource }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var listItem: View? = convertView


        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(mResource, parent, false)

        val movieInfo = getItem(position)

        val title = movieInfo.title
        val director = movieInfo.director

        val txtTitle = listItem?.findViewById(R.id.txtForTitleOrName) as TextView
        val txtDirector = listItem.findViewById(R.id.txtForDirectorOrGender) as TextView
        val btnViewMov = listItem.findViewById(R.id.btnViewMovOrPeople) as ImageButton

        btnViewMov.setOnClickListener{
            val intent = Intent(mContext, ViewMovieActivity::class.java)
            intent.putExtra("movieInfo", movieInfo as Serializable)

            mContext.startActivity(intent)
        }

        txtTitle.text = title
        txtDirector.text = director

        return listItem
    }
}