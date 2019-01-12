package com.dev.nerrawbox.jsonviewparser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.dev.nerrawbox.jsonviewparser.adapter.MovieInfoListAdapter
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract.IPresenterContract
import com.dev.nerrawbox.jsonviewparser.presenter.ExerciseActivityPresenter

class ExerciseActivity : AppCompatActivity(), IExerciseActivityContract.IViewContract {


    private var mPresenter: IPresenterContract? = null
    private var movieInfoListView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        mPresenter = ExerciseActivityPresenter(this, this@ExerciseActivity, R.layout.movie_info_list_view)
        Log.d("Wrn-Act", "OnCreate")
        (mPresenter as ExerciseActivityPresenter).populateListView()

    }

    override fun initListView() {
        Log.d("Wrn-Act", "initListView")
        movieInfoListView = findViewById(R.id.movieInfoListView)
    }

    override fun setListViewAdapter(adapter: MovieInfoListAdapter) {
        Log.d("Wrn-Act", "setListViewAdapter")
        movieInfoListView?.adapter = adapter
    }

}
