package com.mcoolapp.sttestapp.viewmodels

import Datum
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.*
import com.mcoolapp.sttestapp.repository.ApiHelper
import com.mcoolapp.sttestapp.repository.Repository
import com.mcoolapp.sttestapp.repository.Resource
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import org.json.JSONObject

class CurrencyListViewModel(val repository: Repository) : BaseViewModel(repository), LifecycleOwner {

    init {
    }

    fun getList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            setProgressBarVisible()
            emit(Resource.success(data = repository.getCurrencyList().data))

        } catch (exception: Exception) {
            setProgressBarInvisible()
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }


    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }
}