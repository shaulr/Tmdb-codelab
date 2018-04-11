package com.tmdbcodlab.android.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.tmdbcodlab.android.data.source.data.DiscoverResult

/**
 * Created by shaulr on 10/04/18.
 */
@Database(entities = [(DiscoverResult::class)], version = 1)
@TypeConverters(IntArrayConverter::class)
abstract class DiscoverResultDatabase :RoomDatabase() {
    abstract fun discoverResultDao(): DiscoverrResultDao

}