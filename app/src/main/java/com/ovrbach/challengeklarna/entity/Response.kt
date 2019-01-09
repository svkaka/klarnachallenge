package com.ovrbach.challengeklarna.entity

sealed class Response<out T : Any> {
    class Success<out T: Any>(val data: T) : Response<T>()
    class Error(val error: Throwable) : Response<Nothing>()
    object Cancelled : Response<Nothing>()
}