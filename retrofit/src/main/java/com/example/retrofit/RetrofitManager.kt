package com.example.retrofit

import com.example.retrofit.dagger.DaggerRetrofitComponent
import com.example.retrofit.dagger.RetrofitComponent

class RetrofitManager {

    private var retrofitComponent = DaggerRetrofitComponent.create()

    fun getRetrofitComponent(): RetrofitComponent = retrofitComponent

    companion object {
        @JvmStatic
        val instance by lazy {
            RetrofitManager()
        }
    }
}
