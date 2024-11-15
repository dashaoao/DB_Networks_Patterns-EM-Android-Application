package com.dashaoao.db_networks_patterns_em.utils

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        Log.d("LoggingInterceptor", "Response Code: ${response.code}")

        return response
    }
}
