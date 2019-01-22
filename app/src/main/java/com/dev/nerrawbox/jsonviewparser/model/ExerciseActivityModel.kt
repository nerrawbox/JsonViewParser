package com.dev.nerrawbox.jsonviewparser.model

import android.content.Context
import android.util.Log
import com.dev.nerrawbox.jsonviewparser.adapter.MovieListAdapter
import com.dev.nerrawbox.jsonviewparser.adapter.PeopleListAdapter
import com.dev.nerrawbox.jsonviewparser.contract.IExerciseActivityContract
import com.dev.nerrawbox.jsonviewparser.model.dataManager.Movie
import com.dev.nerrawbox.jsonviewparser.model.dataManager.People
import com.dev.nerrawbox.jsonviewparser.model.jsonParser.IJsonParser
import com.dev.nerrawbox.jsonviewparser.model.jsonParser.ParseMovie
import com.dev.nerrawbox.jsonviewparser.model.jsonParser.ParsePeople
import org.json.JSONArray
import java.nio.charset.Charset

class ExerciseActivityModel(private val mContext: Context) : IExerciseActivityContract.IModelContract {

    override fun parseJsonSetMovieAdapter(mResource: Int): MovieListAdapter {

        val parser = ParseMovie(mContext) as IJsonParser.IJsonParserResult<Movie>

        return MovieListAdapter(mContext, mResource, parser.getResultList())
    }

    override fun parseJsonSetPeopleAdapter(mResource: Int): PeopleListAdapter {

        val parser = ParsePeople(mContext) as IJsonParser.IJsonParserResult<People>

        return PeopleListAdapter(mContext, mResource, parser.getResultList())
    }

}