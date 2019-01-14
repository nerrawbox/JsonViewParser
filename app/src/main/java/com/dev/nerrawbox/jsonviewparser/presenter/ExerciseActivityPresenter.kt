package com.dev.nerrawbox.jsonviewparser.presenter

import android.content.Context
import android.view.View
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract.IViewContract
import com.dev.nerrawbox.jsonviewparser.model.ExerciseActivityModel


class ExerciseActivityPresenter(view: IViewContract, context: Context, resource: Int, listType: String)
    : IExerciseActivityContract.IPresenterContract {

    private val mListType = listType
    private val mResource = resource
    private val mContext = context
    private val mView = view
    private val mModel by lazy { ExerciseActivityModel(mContext) }

    init {
        initPresenter()
    }

    private fun initPresenter() {
        mView.initListView()
    }

    override fun populateListView() {
        if(mListType == "movie") {
            val adapter = mModel.parseJsonSetMovieAdapter(mResource)
            mView.setListViewAdapter(adapter)
        }
        else if(mListType == "people"){
            val adapter = mModel.parseJsonSetPeopleAdapter(mResource)
            mView.setListViewAdapter(adapter)
        }
    }

    override fun onClick(view: View) {

    }
}