package com.tmdbcodlab.android.data.source.local

import android.content.Context
import com.tmdbcodlab.android.data.source.TmdbDataSource
import android.arch.persistence.room.Room
import com.tmdbcodlab.android.data.source.data.DiscoverResult
import io.reactivex.Flowable
import io.reactivex.Observable


/**
 * Created by ronelg on 12/19/17.
 */
class TmdbLocalDataSource(val context: Context): TmdbDataSource {
    val db : DiscoverResultDatabase = Room.databaseBuilder(context, DiscoverResultDatabase::class.java, "tmdb").build()

    fun getDiscoverResults() : Flowable<DiscoverResult> {
        return db.discoverResultDao().getDiscoverResults()
    }
}