package com.example.presentation.ui.fragment.login

import android.net.Uri
import android.util.Patterns
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core_ui.base.BaseFragment
import com.example.core_ui.extesions.asUri
import com.example.core_ui.extesions.ifTrue
import com.example.core_ui.extesions.openInBrowser
import com.example.core_ui.extesions.safeNavigation
import com.example.core_ui.extesions.showToast
import com.example.core_ui.utils.Constants
import com.example.core_ui.utils.InputFilters
import com.example.presentation.R
import com.example.presentation.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(R.layout.fragment_login) {

    override val binding by viewBinding(FragmentLoginBinding::bind)
    override val viewModel by viewModel<LoginViewModel>()

    override fun initialize(): Unit = with(binding) {
        viewModel.shouldShowOnBoard().ifTrue {
            findNavController().safeNavigation(LoginFragmentDirections.actionLoginFragmentToOnboardFragment())
        }
        etEmail.filters = arrayOf(InputFilters.LatinOnly)
    }

    override fun setupListeners(): Unit = with(binding) {
        btnLogin.setOnClickListener {
            validateFields().ifTrue {
                val deepLinkUri = Uri.parse("em://mainModule/mainNavGraph")
                findNavController().navigate(deepLinkUri)
            }
        }
        btnVk.setOnClickListener {
            Constants.VK_URL.asUri().openInBrowser(requireContext())
        }
        btnOk.setOnClickListener {
            Constants.OK_URL.asUri().openInBrowser(requireContext())
        }
    }

    private fun validateFields(): Boolean = with(binding) {
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()
        val isPasswordValid = etPassword.text.isNotEmpty()
        return if (isEmailValid && isPasswordValid) {
            true
        } else {
            showToast(getString(com.example.core_ui.R.string.error_incorrect_data))
            false
        }
    }
}