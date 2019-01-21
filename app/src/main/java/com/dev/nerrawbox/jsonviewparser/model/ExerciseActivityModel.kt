package com.dev.nerrawbox.jsonviewparser.model

import android.content.Context
import android.util.Log
import com.dev.nerrawbox.jsonviewparser.adapter.MovieListAdapter
import com.dev.nerrawbox.jsonviewparser.adapter.PeopleListAdapter
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract
import com.dev.nerrawbox.jsonviewparser.model.jsonParser.ParseMovie
import com.dev.nerrawbox.jsonviewparser.model.jsonParser.ParsePeople
import org.json.JSONArray
import java.nio.charset.Charset

class ExerciseActivityModel(private val mContext: Context) : IExerciseActivityContract.IModelContract {

    override fun parseJsonSetMovieAdapter(mResource: Int): MovieListAdapter {
        lateinit var adapter: MovieListAdapter

        ParseMovie(mContext, { result ->
            adapter = MovieListAdapter(mContext, mResource, result)

        }, { error ->
            Log.d("Wrn-mParser-er",  error)

        }).parseJson()

        return adapter
    }

    override fun parseJsonSetPeopleAdapter(mResource: Int): PeopleListAdapter {
        lateinit var adapter: PeopleListAdapter

        ParsePeople(mContext, { result ->
            adapter = PeopleListAdapter(mContext, mResource, result)

        }, { error ->
            Log.d("Wrn-pParser-er",  error)

        }).parseJson()

        return adapter
    }

}