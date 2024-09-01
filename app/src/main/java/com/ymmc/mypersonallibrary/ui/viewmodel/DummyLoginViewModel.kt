package com.ymmc.mypersonallibrary.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ymmc.mypersonallibrary.data.model.UserInfo
import com.ymmc.mypersonallibrary.data.repository.UserInfoRepository

class DummyLoginViewModel(
    private val repository: UserInfoRepository
): ViewModel() {

    fun saveUserInfo(userInfo: UserInfo) {
        repository.saveUserInfo(userInfo)
    }

    fun isRememberMeChecked(): Boolean {
        return repository.isRememberMeChecked()
    }

    companion object {
        private const val TAG = "DummyLoginViewModel"
    }

}