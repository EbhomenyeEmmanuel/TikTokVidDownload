package com.esq.tiktokviddownload.model

import com.squareup.moshi.Json

data class TikTokResponse(
    @Json(name = "data")
    private var data: List<Data> = emptyList(),
    @Json(name = "success")
    private var count: Boolean? = null
)

data class Data(
    @Json(name = "itemInfo")
    private var itemInfo: List<ItemInfo> = emptyList(),
    @Json(name = "statusCode")
    private var statusCode: Int? = null
)

data class ItemInfo(
    @Json(name = "itemStruct")
    private var itemStruct: List<ItemStruct> = emptyList(),
    @Json(name = "shareMeta")
    private var shareMeta: List<ShareMeta> = emptyList()
)

data class ItemStruct(
    @Json(name = "desc")
    private var desc: String? = null,
    @Json(name = "title")
    private var title: String? = null
)

data class ShareMeta(
    @Json(name = "desc")
    private var desc: String? = null,
    @Json(name = "title")
    private var title: String? = null
)