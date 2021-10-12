package com.octovalley.saveomoviemvvm.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.octovalley.saveomoviemvvm.data.api.TheMovieDBInterface
import com.octovalley.saveomoviemvvm.data.repository.MovieDetailsNetworkDataSource
import com.octovalley.saveomoviemvvm.data.repository.NetworkState
import com.octovalley.saveomoviemvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}