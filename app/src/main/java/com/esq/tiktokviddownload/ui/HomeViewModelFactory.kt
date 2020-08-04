package com.esq.tiktokviddownload.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esq.tiktokviddownload.model.UrlModel
import com.esq.tiktokviddownload.model.UrlValidationCallback

class HomeViewModelFactory( private var urlValidationCallBack: UrlValidationCallback,
                           private var tikTokUrl: UrlModel = UrlModel()) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
           HomeViewModel( urlValidationCallBack, tikTokUrl) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}