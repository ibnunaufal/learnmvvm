package id.co.solusinegeri.learnmvvm.ui.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import id.co.solusinegeri.learnmvvm.data.remote.MovieRepository

class MovieViewModel @ViewModelInject constructor(private val repository: MovieRepository) :ViewModel() {
}