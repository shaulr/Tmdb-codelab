package com.tmdbcodlab.android.data.source.remote

import com.tmdbcodlab.android.data.source.data.Discover
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.util.concurrent.CountDownLatch

/**
 * Created by shaulr on 08/04/18.
 */
class TmdbRemoteDataSourceTest {
    var tmdbRemote : TmdbRemoteDataSource? = null
    @Before
    fun setUp() {
        tmdbRemote = TmdbRemoteDataSource()
        assertNotNull("tmdbRemote is not null", tmdbRemote)
        tmdbRemote!!.init()
    }
    @Test
    fun init() {
        assertNotNull("tmdbRemote created API", tmdbRemote!!.tmpbAPI)
    }

    @Test
    fun getPopular() {
        val latch = CountDownLatch(1)
        val tmdbRemote = TmdbRemoteDataSource()
        var results: Discover? = null
        tmdbRemote.init()

        tmdbRemote.getPopular()
                .doOnNext {
                    results = it
                    latch.countDown()
                }
                .doOnError {
                    latch.countDown()
                    assertFalse(it.message, true)
                }
                .subscribe()
        latch.await()

        assertNotNull("got results",results)
        assertNotNull("got results", results?.results)
        assertNotNull("got results", results?.results?.size)

        assertTrue("got results greater then zero", results?.results?.size!! > 0)
        for(result in results?.results!!) {
            assertNotNull("title for ${result.id}", result.title)
            assertNotNull("id for ${result.title}", result.id)
            assertNotNull("popularity for ${result.id}", result.popularity)
            if(result.originalLanguage != null) {
                //foreign movie
                assertNotNull("original title for ${result.title} is null", result.originalTitle)
            }
        }
    }

}