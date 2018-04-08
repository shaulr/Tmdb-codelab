package com.tmdbcodlab.android.data.source.remote

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.tmdbcodlab.android.BuildConfig
import com.tmdbcodlab.android.data.source.TmdbDataSource
import com.tmdbcodlab.android.data.source.data.Discover
import com.tmdbcodlab.android.data.source.data.DiscoverResult
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.xml.transform.Result


/**
 * Created by ronelg on 12/19/17.
 */
class TmdbRemoteDataSource: TmdbDataSource {

    private var moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private var discoverResultJsonAdapter: JsonAdapter<Discover>? = null
    lateinit var tmpbAPI: TmdbAPI
    fun init() {
        discoverResultJsonAdapter = moshi.adapter(Discover::class.java)
        val retrofit = Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.themoviedb.org/3/")
                .build()

        tmpbAPI = retrofit.create(TmdbAPI::class.java)
    }

    fun getPopular() : Observable<Discover> {
        return tmpbAPI.getPopular(BuildConfig.API_KEY)
    }

}