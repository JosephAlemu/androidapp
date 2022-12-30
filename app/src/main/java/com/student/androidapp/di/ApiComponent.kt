package com.student.postapp.di

import com.student.postapp.model.WebServiceCall
import com.student.postapp.viewmodel.MainActivityViewmodel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
   fun inject(service : WebServiceCall)
   fun inject(service : MainActivityViewmodel)
}