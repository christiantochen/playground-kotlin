package com.christiantochen.ppjonline.ui.login

    import android.content.Intent
    import android.os.Bundle
    import android.view.View
    import androidx.databinding.DataBindingUtil
    import androidx.lifecycle.Observer
    import androidx.lifecycle.ViewModelProviders
    import com.christiantochen.ppjonline.R
    import com.christiantochen.ppjonline.databinding.ActivityLoginBinding
    import com.christiantochen.ppjonline.ui.BaseActivity
    import com.christiantochen.ppjonline.ui.main.MainActivity
    import com.christiantochen.ppjonline.utils.extension.showToast
    import com.christiantochen.ppjonline.utils.hideKeyboard
    import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity()
{
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupViewModel()
        setupBinding()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.navigateToMainActivity.observe(this, Observer {
            when(it) {
                true -> this.hideKeyboard().also {
                    finish()
                }.also {
                    startActivity(Intent(this, MainActivity::class.java))
                }
            }
        })
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            when {
                !errorMessage.isNullOrEmpty() -> this.hideKeyboard().also { showToast(errorMessage) }
            }
        })
        viewModel.isLoading.observe(this, Observer {
            when (it) {
                View.VISIBLE -> this.hideKeyboard().also { loginButton.isEnabled = false }
                else -> loginButton.isEnabled = true
            }
        })
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = viewModel
    }
}
