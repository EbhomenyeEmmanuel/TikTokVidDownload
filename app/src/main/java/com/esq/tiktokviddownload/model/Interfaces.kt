package com.esq.tiktokviddownload.model

interface UrlValidationCallback{
    fun onCorrectUrl(errorMessage: String)
    fun onIncorrectUrl(errorMessage: String)
    fun onSendDownloadIntent()
}