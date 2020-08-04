package com.esq.tiktokviddownload.ui

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.esq.tiktokviddownload.model.UrlModel
import com.esq.tiktokviddownload.model.UrlValidationCallback

class HomeViewModel( private var urlValidationCallBack: UrlValidationCallback,  private var mTikTokUrl: UrlModel) : ViewModel() {

    val TAG = HomeViewModel::class.simpleName

    fun getUrlTextWatcher(): TextWatcher? {
        return object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun onTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun afterTextChanged(editable: Editable) {
                mTikTokUrl.url = editable.toString().trim { it <= ' ' }
            }
        }
    }

    fun onDownloadButtonClicked(view: View) {
        val isValidUrl: Boolean = mTikTokUrl.isValidTikTokUrl
        val validUrl: String = mTikTokUrl.url
        if (isValidUrl) {
            urlValidationCallBack.onCorrectUrl(validUrl)
        } else {
            urlValidationCallBack.onIncorrectUrl("InValid Url")
        }
    }

}