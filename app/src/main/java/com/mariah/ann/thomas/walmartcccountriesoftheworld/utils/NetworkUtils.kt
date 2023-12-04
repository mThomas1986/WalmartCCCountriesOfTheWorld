package com.mariah.ann.thomas.walmartcccountriesoftheworld.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class NetworkUtils {
    companion object {
        fun isNetworkAvailable(context: Context) : Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
            } else {
                val networkInfo = connectivityManager.activeNetworkInfo
                networkInfo?.isConnected ?: false
            }
        }
    }
}
