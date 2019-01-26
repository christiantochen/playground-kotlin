package com.christiantochen.ppjonline.ui.login

    import android.arch.lifecycle.Observer
    import android.arch.lifecycle.ViewModelProviders
    import android.content.Intent
    import android.databinding.DataBindingUtil
    import android.os.Bundle
    import android.view.View
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

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.navigateToMainActivity.observe(this, Observer {
            when(it) {
               true -> this.hideKeyboard().also { navigateToMainActivity() }
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
        binding.viewModel = viewModel
    }

    private fun navigateToMainActivity() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }

    companion object {
        const val TAG = "LoginActivity"
    }
}
