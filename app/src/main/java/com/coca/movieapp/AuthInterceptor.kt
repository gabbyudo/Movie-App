package com.coca.movieapp

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Interceptor.*
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class AuthInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        var request: Request = chain.request()
        val url: HttpUrl = request.url.newBuilder()

            .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}