package com.example.account_presentation.ui.fragment

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.account_presentation.R
import com.example.account_presentation.databinding.FragmentAccountBinding
import com.example.core_ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccountFragment: BaseFragment<FragmentAccountBinding, AccountViewModel>(R.layout.fragment_account) {
    override val binding by viewBinding(FragmentAccountBinding::bind)
    override val viewModel by viewModel<AccountViewModel>()
}