package com.example.mytrainermobile.network

class DataSourceException(
    code: Int,
    message: String,
    details: List<String>?
) : Exception(message)