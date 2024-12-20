package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    fun liveData(): LiveData<UiState>

    interface Save : LiveDataWrapper {

        fun save(bundleWrapper: BundleWrapper.Save)
    }

    interface Update : LiveDataWrapper {

        fun update(value: UiState)
    }

    interface Mutable : Save, Update

    class Base : Mutable {

        private val liveData: MutableLiveData<UiState> = SingleLiveEvent()

        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { bundleWrapper.save(it) }
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun liveData(): LiveData<UiState> = liveData
    }
}
