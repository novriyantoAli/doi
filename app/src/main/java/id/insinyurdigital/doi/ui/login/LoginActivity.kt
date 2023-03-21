package id.insinyurdigital.doi.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.insinyurdigital.doi.R
import id.insinyurdigital.doi.data.SessionManager
import id.insinyurdigital.doi.databinding.ActivityLoginBinding
import id.insinyurdigital.doi.domain.DataState
import id.insinyurdigital.doi.ui.MainActivity

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        binding.loginLoginBtn.setOnClickListener {
//            viewModel.postLogin(
//                LoginViewModel.MainStateEvent.GetMemberDetail,
//                binding.loginMobileEditText.text.toString(),
//                binding.loginPasswordEditText.text.toString()
//            )
//            subscribeObservers()
//        }

    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(this) { dataState ->
            when (dataState) {
                is DataState.Error -> {
                    displayLoading(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayLoading(true)
                }
                is DataState.Success -> {
                    displayLoading(false)
                    // save date to shared preference
                    val sessionManager = SessionManager(this)
                    sessionManager.createLoginSession(
                        dataState.data.id,
                        dataState.data.username,
                        dataState.data.token,
                        false
//                        binding.loginRemSwitch.isChecked
                    )
                    val homeIntent = Intent(this, MainActivity::class.java)
                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(homeIntent)
                    finish()
                }
            }
        }
    }

    private fun displayLoading(isDisplayed: Boolean){
//        binding.loginLoginBtn.isEnabled = !isDisplayed
        binding.pbLoading.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    private fun displayError(message: String?){
        Toast.makeText(this, message ?: "Unknown Errors", Toast.LENGTH_SHORT).show()
    }
}

