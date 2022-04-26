package id.co.solusinegeri.learnmvvm.ui.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import id.co.solusinegeri.learnmvvm.data.remote.Movie
import id.co.solusinegeri.learnmvvm.data.remote.MovieRepository
import id.co.solusinegeri.learnmvvm.data.remote.Movies

class MovieViewModel @ViewModelInject constructor(private val repository: MovieRepository) :ViewModel() {

    val movies: LiveData<PagingData<Movie>> = repository.getNowPlayingMovies()
}