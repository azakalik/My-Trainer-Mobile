package com.example.mytrainermobile.network.data

import com.example.mytrainermobile.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {

    //TODO MOVER A BUILD GRADLE CONFIG, no recuerdo si habia o no que poner /API
    private const val URL = "http://localhost:8080"

    private val retrofit: Retrofit


    init {
        //este es para ver en el logcat
        val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        //este es el canal que usamos
        val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
        retrofit = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
    }


    fun getApiService() : ApiService {
        return retrofit.create(ApiService::class.java)
    }
}