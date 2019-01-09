package com.ovrbach.challengeklarna.cases

import com.ovrbach.challengeklarna.entity.Response

interface ResultCallback<T : Any> {
    fun onFinished(result: Response<T>)
}