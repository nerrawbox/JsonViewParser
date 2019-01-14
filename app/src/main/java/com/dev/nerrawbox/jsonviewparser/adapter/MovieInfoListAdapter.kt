package com.dev.nerrawbox.jsonviewparser.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.dev.nerrawbox.jsonviewparser.model.MovieInfo

import com.dev.nerrawbox.jsonviewparser.R
import com.dev.nerrawbox.jsonviewparser.ViewMovieActivity
import java.io.Serializable

class MovieInfoListAdapter(context: Context, resource: Int, objects: List<MovieInfo>?) :
    ArrayAdapter<MovieInfo>(context, resource, objects) {

    private val mContext: Context by lazy { context }
    private val mResource: Int by lazy { resource }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val title = getItem(position)!!.title
        val director = getItem(position)!!.director
        val description = getItem(position)!!.description
        val producer = getItem(position)!!.producer
        val releaseDate = getItem(position)!!.release_date
        val rtScore = getItem(position)!!.rt_score
        
//        Log.d("Wrn", "Adapter: Title =  $title")
//        Log.d("Wrn", "Adapter: Director =  $director")

        var listItem: View? = convertView

        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(mResource, parent, false)

        val txtTitle = listItem?.findViewById(R.id.txtForTitleOrName) as TextView
        val txtDirector = listItem.findViewById(R.id.txtForDirectorOrGender) as TextView
        val btnViewMov = listItem.findViewById(R.id.btnViewMovOrPeople) as ImageButton

        val movieInfo = MovieInfo(title, director, description, producer, releaseDate, rtScore)

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