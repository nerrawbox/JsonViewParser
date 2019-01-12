package com.dev.nerrawbox.jsonviewparser.presenter

import android.content.Context
import android.util.Log
import android.view.View
import com.dev.nerrawbox.jsonviewparser.adapter.MovieInfoListAdapter
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract.IViewContract
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract.IModelContract
import com.dev.nerrawbox.jsonviewparser.model.ExerciseActivityModel

class ExerciseActivityPresenter(view: IViewContract, context: Context, resource: Int) : IExerciseActivityContract.IPresenterContract {

    private val mResource : Int = resource
    private val mContext = context
    private val mView: IViewContract = view
    private val mModel by lazy { ExerciseActivityModel(mContext) }

    init {
        initPresenter()
    }

    private fun initPresenter() {
        mView.initListView()
    }

    override fun populateListView() {
        val adapter = mModel.parseJsonSetAdapter(mResource)
        mView.setListViewAdapter(adapter)
    }

    override fun onClick(view: View) {

    }
}