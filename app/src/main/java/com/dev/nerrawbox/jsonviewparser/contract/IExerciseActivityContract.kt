package com.dev.nerrawbox.jsonviewparser.contract

import com.dev.nerrawbox.jsonviewparser.adapter.MovieListAdapter
import com.dev.nerrawbox.jsonviewparser.adapter.PeopleListAdapter

interface IExerciseActivityContract {

    interface IViewContract {
        fun initListView()
        fun setListViewAdapter(adapter: MovieListAdapter)
        fun setListViewAdapter(adapter: PeopleListAdapter)
    }

    interface IModelContract {
        fun parseJsonSetMovieAdapter(mResource: Int): MovieListAdapter
        fun parseJsonSetPeopleAdapter(mResource: Int): PeopleListAdapter
    }

    interface IPresenterContract {
        fun populateListView(listType: String)
    }
}