package com.ymmc.mypersonallibrary.data.source

import com.ymmc.mypersonallibrary.data.model.UserInfo

interface UserInfoDataSource  {
    fun saveUserInfo(userInfo: UserInfo)
    fun getSavedUsername(): String?
    fun getSavedPassword(): String?
    fun isRememberMeChecked(): Boolean
}