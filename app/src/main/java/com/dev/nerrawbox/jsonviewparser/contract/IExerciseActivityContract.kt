package com.dev.nerrawbox.jsonviewparser.contract

import android.view.View
import com.dev.nerrawbox.jsonviewparser.adapter.MovieInfoListAdapter

interface IExerciseActivityContract {

    interface IViewContract {
        fun initListView()
        fun setListViewAdapter(adapter: MovieInfoListAdapter)
    }

    interface IModelContract {
        fun parseJsonSetAdapter(mResource: Int): MovieInfoListAdapter
    }

    interface IPresenterContract {
        fun populateListView()
        fun onClick(view: View)
    }
}