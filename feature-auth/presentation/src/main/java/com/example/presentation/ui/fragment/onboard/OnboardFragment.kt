package com.example.presentation.ui.fragment.onboard

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core_ui.base.BaseFragment
import com.example.core_ui.extesions.safeNavigation
import com.example.presentation.R
import com.example.presentation.databinding.FragmentOnboardBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnboardFragment :
    BaseFragment<FragmentOnboardBinding, OnboardViewModel>(R.layout.fragment_onboard) {
    override val binding by viewBinding(FragmentOnboardBinding::bind)
    override val viewModel by viewModel<OnboardViewModel>()

    override fun setupListeners(): Unit = with(binding) {
        btnContinue.setOnClickListener {
            viewModel.setOnBoardingShown()
            findNavController().safeNavigation(OnboardFragmentDirections.actionOnboardFragmentToLoginFragment())
        }
    }
}