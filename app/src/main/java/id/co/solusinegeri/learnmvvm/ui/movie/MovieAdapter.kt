package id.co.solusinegeri.learnmvvm.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import id.co.solusinegeri.learnmvvm.R
import id.co.solusinegeri.learnmvvm.data.remote.Movie
import id.co.solusinegeri.learnmvvm.databinding.ItemMovieBinding

class MovieAdapter: PagingDataAdapter<Movie, MovieAdapter.MovieViewHolder>(COMPARATOR) {
    inner class MovieViewHolder(private val binding: ItemMovieBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(movie: Movie){
                    with(binding){
                        Glide.with(itemView)
                            .load("${movie.baseUrl}${movie.poster_path}")
                            .centerCrop()
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .error(R.drawable.ic_error)
                            .into(ivMoviePoster)

                        tvMovieTitle.text = movie.original_title
                    }
                }
            }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        TODO("Not yet implemented")
        val currentItem: Movie? = getItem(position)
        if(currentItem != null){
            holder.bind(currentItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        TODO("Not yet implemented")
        val binding: ItemMovieBinding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    fun submitData(lifecycle: LifecycleOwner, pagingData: PagingData<Movie>?) {

    }

    companion object{
        private val COMPARATOR = object : DiffUtil.ItemCallback<Movie>(){
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
                oldItem.id == newItem.id

        }
    }
}