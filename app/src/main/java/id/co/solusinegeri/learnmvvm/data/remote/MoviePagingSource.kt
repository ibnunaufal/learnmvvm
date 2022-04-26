package id.co.solusinegeri.learnmvvm.data.remote

import androidx.paging.PagingSource
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

class MoviePagingSource (
    private val movieApi: MovieApi
    ) : PagingSource<Int, Result>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        TODO("Not yet implemented")
        return try {
            val position: Int = params.key ?: STARTING_PAGE_INDEX
            val response: MovieResponse = movieApi.getNowPlayingMovies(position)
            val movies: List<Result> = response.results

            LoadResult.Page(
                data = movies,
                prevKey = if(position == STARTING_PAGE_INDEX) null else position-1,
                nextKey = if(movies.isEmpty()) null else position+1
            )
        }catch (e: IOException){
            LoadResult.Error(e)
        }catch (e: HttpException){
            LoadResult.Error(e)
        }
    }
}