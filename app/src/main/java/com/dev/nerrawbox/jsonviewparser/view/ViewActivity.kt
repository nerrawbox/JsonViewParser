package com.dev.nerrawbox.jsonviewparser.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dev.nerrawbox.jsonviewparser.R
import com.dev.nerrawbox.jsonviewparser.R.id.txtViewTitle
import com.dev.nerrawbox.jsonviewparser.model.dataManager.ViewActivityInterface

class ViewActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val txtViewTitle: TextView = findViewById(txtViewTitle)
        val txtViewDirector: TextView = findViewById(R.id.txtViewDirector)
        val txtViewDescription: TextView = findViewById(R.id.txtViewDescription)
        val txtViewProducer: TextView = findViewById(R.id.txtViewProducer)
        val txtViewRelDate: TextView = findViewById(R.id.txtViewRelDate)
        val txtViewScore: TextView = findViewById(R.id.txtViewScore)

        val lbl2: TextView = findViewById(R.id.label2)
        val lbl3: TextView = findViewById(R.id.label3)
        val lbl4: TextView = findViewById(R.id.label4)
        val lbl5: TextView = findViewById(R.id.label5)

        if(intent != null){
            @Suppress("UNCHECKED_CAST")
            val viewInterface = intent.extras.get("viewInfo")
                    as ViewActivityInterface

            txtViewTitle.text = viewInterface.getDetail1()
            txtViewDirector.text = viewInterface.getDetail2()
            txtViewDescription.text = viewInterface.getDetail3()
            txtViewProducer.text = viewInterface.getDetail4()
            txtViewRelDate.text = viewInterface.getDetail5()
            txtViewScore.text = viewInterface.getDetail5()

            lbl2.text = viewInterface.getLabel2()
            lbl3.text = viewInterface.getLabel3()
            lbl4.text = viewInterface.getLabel4()
            lbl5.text = viewInterface.getLabel5()

        }
    }

}