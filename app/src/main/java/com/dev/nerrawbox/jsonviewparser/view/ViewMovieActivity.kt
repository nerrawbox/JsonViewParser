package com.dev.nerrawbox.jsonviewparser.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dev.nerrawbox.jsonviewparser.R
import com.dev.nerrawbox.jsonviewparser.model.dataManager.IDataManager

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
            @Suppress("UNCHECKED_CAST")
            val movInfo = intent.extras.get("movieInfo")
                    as IDataManager.IDataClassManager<IDataManager.IMovie>

            txtViewTitle.text = movInfo.getDetail().title
            txtViewDirector.text = movInfo.getDetail().director
            txtViewDescription.text = movInfo.getDetail().description
            txtViewProducer.text = movInfo.getDetail().producer
            txtViewRelDate.text = movInfo.getDetail().releaseDate
            txtViewScore.text = movInfo.getDetail().rtScore
        }
    }
}
