package com.dev.nerrawbox.jsonviewparser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ViewMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_movie)

        if(intent != null){
            val txtViewTitle: TextView = findViewById(R.id.txtViewTitle)
            val txtViewDirector: TextView = findViewById(R.id.txtViewDirector)
            val txtViewDescription: TextView = findViewById(R.id.txtViewDescription)
            val txtViewProducer: TextView = findViewById(R.id.txtViewProducer)
            val txtViewRelDate: TextView = findViewById(R.id.txtViewRelDate)
            val txtViewScore: TextView = findViewById(R.id.txtViewScore)

            txtViewTitle.text = intent.getStringExtra("title")
            txtViewDirector.text = intent.getStringExtra("director")
            txtViewDescription.text = intent.getStringExtra("description")
            txtViewProducer.text = intent.getStringExtra("producer")
            txtViewRelDate.text = intent.getStringExtra("release_date")
            txtViewScore.text = intent.getStringExtra("rt_score")
        }
    }
}
