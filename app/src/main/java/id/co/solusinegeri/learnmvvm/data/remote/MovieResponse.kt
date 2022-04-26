package id.co.solusinegeri.learnmvvm.data.remote


import androidx.annotation.Keep

@Keep
data class MovieResponse(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)