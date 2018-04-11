package com.tmdbcodlab.android.data.source.local

import android.arch.persistence.room.*
import com.tmdbcodlab.android.data.source.data.DiscoverResult
import io.reactivex.Flowable

/**
 * Created by shaulr on 10/04/18.
 */
@Dao
interface DiscoverrResultDao {
    @Query("SELECT * FROM discover")
    fun getDiscoverResults() : Flowable<DiscoverResult>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(result: DiscoverResult)

    @Delete
    fun deleteItem(result: DiscoverResult)
}