package com.mariah.ann.thomas.walmartcccountriesoftheworld.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.mariah.ann.thomas.walmartcccountriesoftheworld.data.model.CountryModel
import com.mariah.ann.thomas.walmartcccountriesoftheworld.data.remote.CountryRetrofitHelper
import com.mariah.ann.thomas.walmartcccountriesoftheworld.utils.NetworkUtils


class CountryViewModel(application: Application) : AndroidViewModel(application) {
    private val _countryData :  LiveData<UIState<ArrayList<CountryModel>>> = liveData {
        emit(UIState.Loading)

        if(NetworkUtils.isNetworkAvailable(getApplication())) {
            val result = CountryRetrofitHelper.countryService.getCountries()
            if(result.isSuccessful) {
                emit(UIState.Success(result.body()!!))
            } else {
                emit(UIState.Error(result.message()))
            }
        } else {
            emit(UIState.Error("Network Unavailable"))
        }

    }

    val countryData = _countryData
}
