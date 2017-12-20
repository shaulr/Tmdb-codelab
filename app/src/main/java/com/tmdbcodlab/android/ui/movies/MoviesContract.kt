package com.tmdbcodlab.android.ui.movies

import com.tikalk.mobileevent.mobileevent.BasePresenter
import com.tikalk.mobileevent.mobileevent.BaseView

/**
 * Created by ronelg on 12/19/17.
 */
interface MoviesContract {

    interface View : BaseView<Presenter> {

        fun setLoadingIndicator(active: Boolean)
    }

    interface Presenter : BasePresenter {

        fun loadMovies(forceUpdate: Boolean)
    }
}