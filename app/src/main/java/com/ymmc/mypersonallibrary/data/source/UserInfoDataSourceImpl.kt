package com.ymmc.mypersonallibrary.data.source

import android.content.SharedPreferences
import com.ymmc.mypersonallibrary.data.model.UserInfo

class UserInfoDataSourceImpl(
    private val sharedPreferences: SharedPreferences
): UserInfoDataSource  {

    override fun saveUserInfo(userInfo: UserInfo) {
        sharedPreferences.edit().apply {
            putString("username", userInfo.userName)
            putString("password", userInfo.password)
            putBoolean("rememberMe", userInfo.shouldRememberMe)
            apply()
        }
    }

    override fun getSavedUsername(): String? {
       return sharedPreferences.getString("username", null)
    }

    override fun getSavedPassword(): String? {
        return sharedPreferences.getString("password", null)
    }

    override fun isRememberMeChecked(): Boolean {
        return sharedPreferences.getBoolean("rememberMe", false)
    }
}