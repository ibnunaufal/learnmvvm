package id.co.solusinegeri.learnmvvm.data.remote

import id.co.solusinegeri.learnmvvm.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = BuildConfig.MOVIEDB_API_KEY
    }

    @GET("movie/now_playing?api_key=$API_KEY")
    suspend fun getNowPlayingMovies(
        @Query("page") position: Int
    ) : MovieResponse
}