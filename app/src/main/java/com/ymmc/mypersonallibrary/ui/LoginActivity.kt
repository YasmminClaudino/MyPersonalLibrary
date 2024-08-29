package com.ymmc.mypersonallibrary.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ymmc.mypersonallibrary.R
import com.ymmc.mypersonallibrary.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)
    }

    companion object {
        private const val TAG = "LoginActivity"
    }
}