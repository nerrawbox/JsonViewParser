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
            val movInfo = intent.extras.get("movieInfo") as IDataManager.IDataClassManager

            txtViewTitle.text = movInfo.getDetail1()
            txtViewDirector.text = movInfo.getDetail2()
            txtViewDescription.text = movInfo.getDetail3()
            txtViewProducer.text = movInfo.getDetail4()
            txtViewRelDate.text = movInfo.getDetail5()
            txtViewScore.text = movInfo.getDetail6()
        }
    }
}
