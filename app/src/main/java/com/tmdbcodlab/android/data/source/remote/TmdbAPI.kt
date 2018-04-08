package com.tmdbcodlab.android.data.source.remote


import com.tmdbcodlab.android.data.source.data.Discover
import com.tmdbcodlab.android.data.source.data.DiscoverResult
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by shaulr on 08/04/18.
 */
interface TmdbAPI {

//    @Headers(   "Accept: application/json",
//                "bearer {apiKey}")
//    @GET("/authentication/token/new")
//    fun requestToken(@Header("apiKey") apiKey: String) : SessionResponse
//
//
//    @GET("/authentication/guest_session/new")
//    fun createGuestsession(@Query("api_key") api_key: String): SessionResponse

    @GET("discover/movie")
    fun getPopular(@Query("api_key") api_key: String ,@Query("sort_by") sort: String = "popularity.desc"): Observable<Discover>
}