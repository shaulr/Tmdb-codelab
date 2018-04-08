package com.tmdbcodlab.android.data.source.data

import com.squareup.moshi.Json



/**
 * Created by shaulr on 08/04/18.
 */
data class Discover (

    @Json(name = "page")
    var page: Int? = null,
    @Json(name = "total_results")
    var totalResults: Int? = null,
    @Json(name = "total_pages")
    var totalPages: Int? = null,
    @Json(name = "results")
    var results: List<DiscoverResult>? = null

)
