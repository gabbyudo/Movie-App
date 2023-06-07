package com.coca.movieapp


import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.themoviedb.org/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
       level = HttpLoggingInterceptor.Level.BODY
    }

    val client : OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(interceptor)
        addInterceptor(AuthInterceptor())
    } .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface MovieApiService {
    @GET("3/movie/popular")
    suspend fun getMovies():  MovieResponse

   /* @GET("promos/{parameter1}/somethingOnething/{parameter2}"
        fun getMovieId(@Path("parameter1") promoId: String, @Path("parameter2") anotherParameter: String):...
*/
    @GET("3/movie/{house}")
    suspend fun getMovie(@Path("house") movieId:Int): Movie
}
object MovieApi {
    val retrofitService : MovieApiService =
        retrofit.create(MovieApiService::class.java)
}