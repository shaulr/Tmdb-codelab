package com.tmdbcodlab.android.data.source.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json

/**
 * Created by shaulr on 08/04/18.
 */
@Entity(tableName = "discover")
data class DiscoverResult (
    @Json(name = "vote_count")
    var voteCount: Int? = null,
    @PrimaryKey
    @Json(name = "id")
    var id: Int? = null,
    @Json(name = "video")
    var video: Boolean? = null,
    @Json(name = "vote_average")
    var voteAverage: Float? = null,
    @Json(name = "title")
    var title: String? = null,
    @Json(name = "popularity")
    var popularity: Float? = null,
    @Json(name = "poster_path")
    var posterPath: String? = null,
    @Json(name = "original_language")
    var originalLanguage: String? = null,
    @Json(name = "original_title")
    var originalTitle: String? = null,
    @Json(name = "genre_ids")
    var genreIds: List<Int>? = null,
    @Json(name = "backdrop_path")
    var backdropPath: String? = null,
    @Json(name = "adult")
    var adult: Boolean? = null,
    @Json(name = "overview")
    var overview: String? = null,
    @Json(name = "release_date")
    var releaseDate: String? = null
) {
    @Ignore constructor() : this(0)

}