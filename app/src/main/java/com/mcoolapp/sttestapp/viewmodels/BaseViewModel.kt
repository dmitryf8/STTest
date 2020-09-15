package com.mcoolapp.sttestapp.viewmodels

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mcoolapp.sttestapp.repository.Repository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel(private val repository: Repository) : ViewModel() {
    private val disposable = CompositeDisposable()
    private val progressBarVisibility = MutableLiveData<Int>()

    init {
        progressBarVisibility.value = View.GONE
    }
    fun getProgressBarVisibility(): MutableLiveData<Int>{
        return progressBarVisibility
    }

    fun Disposable.addTo(compositeDisposable: CompositeDisposable) {
        compositeDisposable.add(this)
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }

    fun setProgressBarVisible() {
        progressBarVisibility.postValue(View.VISIBLE)
    }

    fun setProgressBarInvisible() {
        progressBarVisibility.postValue(View.GONE)
    }
}