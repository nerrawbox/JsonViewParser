package com.dev.nerrawbox.jsonviewparser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.dev.nerrawbox.jsonviewparser.adapter.MovieListAdapter
import com.dev.nerrawbox.jsonviewparser.adapter.PeopleListAdapter
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract.IPresenterContract
import com.dev.nerrawbox.jsonviewparser.presenter.ExerciseActivityPresenter

class ExerciseActivity : AppCompatActivity(), IExerciseActivityContract.IViewContract {


    private lateinit var mPresenter: IPresenterContract
    private lateinit var movieInfoListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        Log.d("Wrn-Act", "OnCreate")

        mPresenter = ExerciseActivityPresenter(this, this@ExerciseActivity, R.layout.my_listview_layout)

        val listType: String = intent.getStringExtra("list_type")
        mPresenter.populateListView(listType)
    }

    override fun initListView() {
        Log.d("Wrn-Act", "initListView")
        movieInfoListView = findViewById(R.id.movieInfoListView)
    }

    override fun setListViewAdapter(adapter: MovieListAdapter) {
        Log.d("Wrn-Act", "setListViewAdapter")
        movieInfoListView.adapter = adapter
    }

    override fun setListViewAdapter(adapter: PeopleListAdapter) {
        Log.d("Wrn-Act", "setListViewAdapter")
        movieInfoListView.adapter = adapter
    }
}
