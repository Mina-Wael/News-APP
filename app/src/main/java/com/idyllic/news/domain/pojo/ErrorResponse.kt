package com.idyllic.news.domain.pojo

data class ErrorResponse(
    val code: String,
    val message: String,
    val status: String
)