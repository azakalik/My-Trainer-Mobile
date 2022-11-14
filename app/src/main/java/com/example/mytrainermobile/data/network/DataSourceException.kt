package com.example.mytrainermobile.data.network

class DataSourceException(
    code: Int,
    message: String,
    details: List<String>?
) : Exception(message)