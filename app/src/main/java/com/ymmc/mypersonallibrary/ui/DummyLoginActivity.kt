package com.ymmc.mypersonallibrary.ui

import android.content.Intent
import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.appcompat.app.AppCompatActivity
import com.ymmc.mypersonallibrary.data.model.UserInfo
import com.ymmc.mypersonallibrary.databinding.ActivityDummyLoginBinding
import com.ymmc.mypersonallibrary.ui.viewmodel.DummyLoginViewModel

class DummyLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDummyLoginBinding
    private var isChecked: Boolean = false
    private lateinit var userName: String
    private lateinit var userPassword: String

    private val viewModel: DummyLoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDummyLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (viewModel.isRememberMeChecked()) {
            startBookListActivity()
        } else {
            setupLoginButton()
        }

    }

    private fun startBookListActivity() {
        val intent = Intent(this@DummyLoginActivity, SearchBooks::class.java)
        startActivity(intent)
        finish()
    }

    private fun setupLoginButton() {
        binding.apply {
            rememberMeCheckBox.setOnCheckedChangeListener { _, isCheckBoxChecked ->
               isChecked = isCheckBoxChecked
            }
            userName = usernameEditText.text.toString()
            userPassword = passwordEditText.text.toString()
            loginButton.setOnClickListener {
                if (userPassword != null && userName != null) {
                    viewModel.saveUserInfo(UserInfo( userName, userPassword, isChecked))
                    startBookListActivity()
                }
            }
        }
    }
}