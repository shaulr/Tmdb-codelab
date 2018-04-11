package com.tmdbcodlab.android.data.source.local

import android.arch.persistence.room.TypeConverter

/**
 * Created by shaulr on 10/04/18.
 */

class IntArrayConverter {
    private val regex = "\\s*,\\s*".toRegex()

    @TypeConverter
    fun toString(list: List<Int>) : String {
        return list.joinToString(",")
    }

    @TypeConverter
    fun toList(list: String): List<Int> {
        return list.split(regex).map { it.toInt() }
    }

}