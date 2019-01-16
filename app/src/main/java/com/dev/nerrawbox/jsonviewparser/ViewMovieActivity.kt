package com.dev.nerrawbox.jsonviewparser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dev.nerrawbox.jsonviewparser.model.MovieInfo

class ViewMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_movie)

        val txtViewTitle: TextView = findViewById(R.id.txtViewTitle)
        val txtViewDirector: TextView = findViewById(R.id.txtViewDirector)
        val txtViewDescription: TextView = findViewById(R.id.txtViewDescription)
        val txtViewProducer: TextView = findViewById(R.id.txtViewProducer)
        val txtViewRelDate: TextView = findViewById(R.id.txtViewRelDate)
        val txtViewScore: TextView = findViewById(R.id.txtViewScore)

        if(intent != null){
            val movInfo = intent.extras.get("movieInfo") as MovieInfo

            txtViewTitle.text = movInfo.title
            txtViewDirector.text = movInfo.director
            txtViewDescription.text = movInfo.description
            txtViewProducer.text = movInfo.producer
            txtViewRelDate.text = movInfo.release_date
            txtViewScore.text = movInfo.rt_score
        }
    }
}
