package com.student.postapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.student.postapp.R
import com.student.postapp.viewmodel.MainActivityViewmodel

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityViewmodel: MainActivityViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewmodel = ViewModelProvider(this).get(MainActivityViewmodel::class.java)
        mainActivityViewmodel.getEmployeeCaller()
    }
}