package com.esq.tiktokviddownload.data

import com.esq.tiktokviddownload.api.TikTokService
import com.esq.tiktokviddownload.model.TikTokResponse

class TikTokRepo() {
    var client: TikTokService = TikTokService.client

    suspend fun getTikTok(token: String, url: String): TikTokResponse =
        client.getTikTokObject(token = token, url = url)
}

