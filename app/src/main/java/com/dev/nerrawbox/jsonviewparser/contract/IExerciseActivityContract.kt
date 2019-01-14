package com.dev.nerrawbox.jsonviewparser.contract

import android.view.View
import com.dev.nerrawbox.jsonviewparser.adapter.MovieInfoListAdapter
import com.dev.nerrawbox.jsonviewparser.adapter.PeopleInfoAdapter

interface IExerciseActivityContract {

    interface IViewContract {
        fun initListView()
        fun setListViewAdapter(adapter: MovieInfoListAdapter)
        fun setListViewAdapter(adapter: PeopleInfoAdapter)
    }

    interface IModelContract {
        fun parseJsonSetMovieAdapter(mResource: Int): MovieInfoListAdapter
        fun parseJsonSetPeopleAdapter(mResource: Int): PeopleInfoAdapter
    }

    interface IPresenterContract {
        fun populateListView()
        fun onClick(view: View)
    }
}