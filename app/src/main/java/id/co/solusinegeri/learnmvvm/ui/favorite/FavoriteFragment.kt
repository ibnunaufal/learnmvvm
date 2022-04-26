package id.co.solusinegeri.learnmvvm.ui.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.co.solusinegeri.learnmvvm.R
import id.co.solusinegeri.learnmvvm.ui.movie.MovieViewModel

@AndroidEntryPoint
class FavoriteFragment: Fragment(R.layout.fragment_favorite ) {

    private val viewModel by viewModels<MovieViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.movies.observe(viewLifecycleOwner){

        }
    }
}