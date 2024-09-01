package com.ymmc.mypersonallibrary.data.repository

import com.ymmc.mypersonallibrary.data.model.UserInfo

interface UserInfoRepository {
    fun saveUserInfo(userInfo: UserInfo)
    fun getSavedUsername(): String?
    fun getSavedPassword(): String?
    fun isRememberMeChecked(): Boolean
}