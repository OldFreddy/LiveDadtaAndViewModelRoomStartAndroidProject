package com.oldfredddy.roomstartandroidproject.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oldfredddy.roomstartandroidproject.App
import com.oldfredddy.roomstartandroidproject.Employee

class MainActivityViewModel : ViewModel() {
    var listLiveData = App.database?.employeeDao()?.getAll()
    var employeeLiveData = MutableLiveData<Employee>()
}