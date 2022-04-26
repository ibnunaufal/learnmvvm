package id.co.solusinegeri.learnmvvm.data.remote


import androidx.annotation.Keep

@Keep
data class MovieResponse(
    val results: List<Movie>
)