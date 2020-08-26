package com.jenius.travel

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import okhttp3.OkHttpClient

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val logging = HttpLoggingInterceptor()
        logging.level = (HttpLoggingInterceptor.Level.BASIC)

        val okHttpClient = OkHttpClient().newBuilder()
            .addNetworkInterceptor(logging)
            .build()
        AndroidNetworking.initialize(applicationContext, okHttpClient)
    }
}