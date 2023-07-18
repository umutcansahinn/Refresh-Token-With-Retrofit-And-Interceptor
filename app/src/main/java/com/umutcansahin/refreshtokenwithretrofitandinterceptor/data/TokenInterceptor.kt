package com.umutcansahin.refreshtokenwithretrofitandinterceptor.data

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor (
    private val token:String,
    private val tokenType: String
):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val response = chain.proceed(originalRequest)
        if (response.code == 401) {
            val newRequest = originalRequest
                .newBuilder()
                .header("Authorization","$tokenType $token")
                .build()
            return chain.proceed(newRequest)
        }
        response.close()
        return chain.proceed(originalRequest)
    }
}