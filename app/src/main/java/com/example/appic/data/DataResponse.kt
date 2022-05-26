package com.example.appic.data

data class DataResponse(
    val errorCode: String?,
    val filterData: List<FilterData>?,
    val message: String?,
    val status: String?
)