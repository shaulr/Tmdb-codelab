package com.tmdbcodlab.android.data.source.remote


import com.tmdbcodlab.android.data.source.data.Discover
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by shaulr on 08/04/18.
 */
interface TmdbAPI {

    @GET("discover/movie")
    fun getPopular(@Query("api_key") api_key: String ,@Query("sort_by") sort: String = "popularity.desc"): Observable<Discover>
}