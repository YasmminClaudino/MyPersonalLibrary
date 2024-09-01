package com.ymmc.mypersonallibrary.data.repository

import com.ymmc.mypersonallibrary.data.model.UserInfo
import com.ymmc.mypersonallibrary.data.source.UserInfoDataSource

class UserInfoRepositoryImpl(
    private val userInfoDataSource: UserInfoDataSource
) : UserInfoRepository  {
    override fun saveUserInfo(userInfo: UserInfo) {
        userInfoDataSource.saveUserInfo(userInfo)
    }

    override fun getSavedUsername(): String? {
       return userInfoDataSource.getSavedUsername()
    }

    override fun getSavedPassword(): String? {
      return  userInfoDataSource.getSavedPassword()
    }

    override fun isRememberMeChecked(): Boolean {
        return userInfoDataSource.isRememberMeChecked()
    }

}