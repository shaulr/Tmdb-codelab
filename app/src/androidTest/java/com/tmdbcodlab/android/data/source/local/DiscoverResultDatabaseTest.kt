package com.tmdbcodlab.android.data.source.local

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.persistence.room.Room
import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4

import com.tmdbcodlab.android.data.source.data.DiscoverResult
import org.junit.*

import org.junit.runner.RunWith
import java.io.IOException


/**
 * Created by shaulr on 10/04/18.
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class DiscoverResultDatabaseTest  {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    var mDb : DiscoverResultDatabase? = null
    lateinit var mContext : Context
    lateinit var mDao : DiscoverrResultDao
    var itemCount = 0

    @Before
    fun setUp() {
        mContext = InstrumentationRegistry.getTargetContext()

        mDb = Room
                .inMemoryDatabaseBuilder(mContext, DiscoverResultDatabase::class.java)
                .allowMainThreadQueries()
                .build()
        mDao = mDb?.discoverResultDao()!!
    }

    @After
    @Throws(IOException::class)
    fun closeDb()
    {
        if(mDb != null)
            mDb?.close()
    }


    @Test
    fun getDiscoverResults() {
        mDao.insertItem(DiscoverResult(
                1,
                1,
                true,
                3.2f,
                "Movie 1",
                4.2f,
                "/poster",
                "en",
                null, listOf(1, 2, 3),
                "/backdrop",
                false,
                "movie 1 overview",
                "movie 1 release date"
        ))
        mDao.insertItem(DiscoverResult(
                1,
                2,
                true,
                3.2f,
                "Movie 2",
                4.2f,
                "/poster",
                "en",
                null, listOf(1, 2, 3),
                "/backdrop",
                false,
                "movie 2 overview",
                "movie 2 release date"
        ))
        mDao.insertItem(DiscoverResult(
                1,
                3,
                true,
                3.2f,
                "Movie 3",
                4.2f,
                "/poster",
                "en",
                null, listOf(1, 2, 3),
                "/backdrop",
                false,
                "movie 3 overview",
                "movie 3 release date"
        ))

        mDao.insertItem(DiscoverResult(
                1,
                3,
                true,
                3.2f,
                "Movie 3 new",
                4.2f,
                "/poster",
                "en",
                null, listOf(1, 2, 3),
                "/backdrop",
                false,
                "movie 3 overview new ",
                "movie 3 release date new"
        ))
        mDao.getDiscoverResults()
                .test()
                .assertValue({
                    it.id!! in 1..3
                })
    }


}