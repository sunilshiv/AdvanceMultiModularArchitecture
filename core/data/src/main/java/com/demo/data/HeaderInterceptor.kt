package com.demo.data

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(
    private val clientId: String,
    private val accessTokenProvider: () -> String?,
    private val languageProvider: () -> String?
    ): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("Not yet implemented")
    }
}
