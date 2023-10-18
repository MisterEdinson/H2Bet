package com.example.h2bet.di

import com.example.h2bet.data.Constants.Companion.URL_LINE
import com.example.h2bet.data.network.SimpleRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ModuleApp {
    @Provides
    fun baseUrl() = URL_LINE
    @Provides
    fun logging() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    @Provides
    fun okHttpClient() = OkHttpClient.Builder().addInterceptor(logging()).build()
    @Provides
    fun gson(): GsonConverterFactory = GsonConverterFactory.create()
    @Provides
    fun provideRetrofit(): SimpleRetrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl())
            .addConverterFactory(gson())
            .client(okHttpClient())
            .build()
            .create(SimpleRetrofit::class.java)
}