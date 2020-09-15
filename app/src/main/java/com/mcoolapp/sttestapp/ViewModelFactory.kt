package com.mcoolapp.sttestapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mcoolapp.sttestapp.repository.ApiHelper
import com.mcoolapp.sttestapp.repository.Repository
import com.mcoolapp.sttestapp.viewmodels.CurrencyListViewModel
import com.mcoolapp.sttestapp.viewmodels.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(Repository(apiHelper)) as T
        } else if (modelClass.isAssignableFrom(CurrencyListViewModel::class.java))
            return CurrencyListViewModel(Repository(apiHelper)) as T else
        throw IllegalArgumentException("Unknown class name")
    }

}