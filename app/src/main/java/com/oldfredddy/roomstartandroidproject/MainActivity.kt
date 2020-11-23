package com.oldfredddy.roomstartandroidproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.oldfredddy.roomstartandroidproject.ViewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    lateinit var mViewModel: MainActivityViewModel
    val dbDao = App.database?.employeeDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }


    override fun onStart() {
        super.onStart()


        mViewModel.listLiveData?.observe(this, Observer {
            tvSalary.text = it[0].salary.toString()
        })
        mViewModel.employeeLiveData.observe(this, Observer {
            GlobalScope.launch {
                dbDao?.insert(it)
            }

        })
        val employee: Employee = Employee(null, "John Smith", 10000)
        mViewModel.employeeLiveData.value = employee
    }
}