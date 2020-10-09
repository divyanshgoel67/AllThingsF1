package com.example.retrofit.dagger

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun getRetrofitClient(): Retrofit {

            return Retrofit.Builder()
                .baseUrl("https://ergast.com/api/f1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}
