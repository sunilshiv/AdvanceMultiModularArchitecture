package com.demo.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.Locale
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    @Named("Language")
    fun provideLanguage(): Locale {
        return Locale.ENGLISH // Todo later get language from user prefs and move it to config module
    }

    @Provides
    @Singleton
    @Named("AccessToken")
    fun provideAccessToken(): () -> String? {
        return { "" } // Todo later get access token from user prefs and move it to config module
    }

    @Provides
    @Singleton
    @Named("ClientId")
    fun provideClientId(): () -> String {
        return { "" } // Todo later get client id from user prefs and move it to config module
    }

    @Provides
    @Singleton
    @Named("HeaderInterceptor")
    fun provideHeaderInterceptor(
        @Named("ClientId") clientId: String,
        @Named("AccessToken") accessToken: () -> String?,
        @Named("Language") language: () -> Locale,
    ): Interceptor {
        return HeaderInterceptor(clientId, accessToken, language)
    }

    // Http Logging interceptor
    @Provides
    @Singleton
    @Named("OkHttpLoggingIntercept0r")
    fun providerOkHttpLoggingIntercept0r(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        if (!BuildConfig.DEBUG) {
            interceptor.redactHeader(CLIENT_ID_HEADER)
            interceptor.redactHeader(AUTHORIZATION_HEADER) // Redact any header that contains sensitive header.
        }
        return interceptor
    }

    // OKHttp call factory
    @Provides
    @Singleton
    @Named("OkHttpCallFactory")
    fun providerOkHttpCallFactory(interceptor: Interceptor): Call.Factory {
        return OkHttpClient.Builder().addInterceptor(interceptor)
            .retryOnConnectionFailure(true)
            .followRedirects(false)
            .followSslRedirects(false)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }
}
