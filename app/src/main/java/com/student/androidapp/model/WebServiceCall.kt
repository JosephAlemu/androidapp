package com.student.postapp.model

import com.google.gson.GsonBuilder
import com.student.postapp.di.DaggerApiComponent
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class WebServiceCall {
    @Inject
    lateinit var api: EmployeeApi
    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getEmpployee(): Single<EmployeeList> {
        return api.getEmployee()
    }

    fun getCountries(): Single<List<Country>> {
        return api.getCountries()
    }
}