package com.dev.nerrawbox.jsonviewparser.presenter

import android.content.Context
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract.IViewContract
import com.dev.nerrawbox.jsonviewparser.model.ExerciseActivityModel


class ExerciseActivityPresenter(private val mView: IViewContract, private val mContext: Context,
                                private val mResource: Int) : IExerciseActivityContract.IPresenterContract {

    private val mModel by lazy { ExerciseActivityModel(mContext) }

    init {
        initPresenter()
    }

    private fun initPresenter() {
        mView.initListView()
    }

    override fun populateListView(listType: String) {
        if(listType == "movie") {
            val adapter = mModel.parseJsonSetMovieAdapter(mResource)
            mView.setListViewAdapter(adapter)
        }
        else if(listType == "people"){
            val adapter = mModel.parseJsonSetPeopleAdapter(mResource)
            mView.setListViewAdapter(adapter)
        }
    }

}