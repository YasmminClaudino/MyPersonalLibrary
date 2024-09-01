package com.ymmc.mypersonallibrary.data.model

data class UserInfo(
    val userName: String,
    val password: String,
    val shouldRememberMe: Boolean = false
)