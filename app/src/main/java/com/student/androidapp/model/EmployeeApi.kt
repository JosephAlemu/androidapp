package com.student.postapp.model

import io.reactivex.Single
import retrofit2.http.GET

interface EmployeeApi {
    @GET("api/v1/employees")
    fun getEmployee(): Single<EmployeeList>
    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries(): Single<List<Country>>
}
