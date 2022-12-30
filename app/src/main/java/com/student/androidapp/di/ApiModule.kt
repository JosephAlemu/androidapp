package com.student.postapp.di

import com.student.postapp.model.EmployeeApi
import com.student.postapp.model.WebServiceCall
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
@Module
class ApiModule {

    val BASE_URL = "https://dummy.restapiexample.com"
    // private val BASE_URL = "https://raw.githubusercontent.com"
    @Provides
    fun provideEmployeeApi(): EmployeeApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EmployeeApi::class.java)
    }
    @Provides
    fun provideWebServiceCall(): WebServiceCall{
        return WebServiceCall()
    }
}