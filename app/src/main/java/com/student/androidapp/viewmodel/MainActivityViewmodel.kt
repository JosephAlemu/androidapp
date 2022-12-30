package com.student.postapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.student.postapp.di.DaggerApiComponent
import com.student.postapp.model.Country
import com.student.postapp.model.Employee
import com.student.postapp.model.EmployeeList
import com.student.postapp.model.WebServiceCall
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivityViewmodel : ViewModel() {
    @Inject
    lateinit var webservicecall : WebServiceCall
    val mydisposable = CompositeDisposable()
   init {
       DaggerApiComponent.create().inject(this)
   }
    fun getEmployeeCaller() {
        getEmployee()
    }

    private fun getEmployee() {
        mydisposable.add(
            webservicecall.getEmpployee()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<EmployeeList>() {
                    override fun onSuccess(t: EmployeeList?) {
                        Log.d("MainActivityViewmodel", t.toString())
                    }

                    override fun onError(e: Throwable) {
                        Log.e("MainActivityViewmodel", e.toString())
                    }
                })
        )


    }

    private fun getCountries() {
        mydisposable.add(
            webservicecall.getCountries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>() {
                    override fun onSuccess(t: List<Country>?) {
                        Log.d("MainActivityViewmodel", t.toString())
                    }

                    override fun onError(e: Throwable) {
                        Log.e("MainActivityViewmodel", e.toString())
                    }
                })
        )


    }
}


