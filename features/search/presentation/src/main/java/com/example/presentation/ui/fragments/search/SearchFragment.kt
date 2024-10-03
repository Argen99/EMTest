package com.example.presentation.ui.fragments.search

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.model.Vacancy
import com.example.core_ui.base.BaseFragment
import com.example.core_ui.extensions.openLink
import com.example.core_ui.extensions.safeNavigation
import com.example.core_ui.extensions.showToast
import com.example.core_ui.utils.UIState
import com.example.presentation.R
import com.example.presentation.databinding.FragmentSearchBinding
import com.example.presentation.ui.adapter.MainAdapter
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewModel>(R.layout.fragment_search) {

    override val binding by viewBinding(FragmentSearchBinding::bind)
    override val viewModel by viewModel<SearchViewModel>()

    private val offerAdapter: MainAdapter by lazy {
        MainAdapter(
            context = requireContext(),
            onOfferItemClick = { context?.openLink(it) })
    }
    private val vacancyAdapter: MainAdapter by lazy {
        MainAdapter(
            context = requireContext(),
            onFavoriteClick = ::onFavoriteClick,
            onVacancyItemClick = ::onVacancyItemCLick
        )
    }

    override fun initialize() {
        binding.rvOffers.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = offerAdapter
        }

        binding.rvVacancies.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = vacancyAdapter
        }
    }

    override fun setupListeners() {
        binding.btnMoreVacancies.setOnClickListener {
            viewModel.switchScreenState()
        }
        binding.btnBack.setOnClickListener {
            viewModel.switchScreenState()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun launchObservers() {
        viewModel.mainData.spectateUiState(
            progressBar = binding.progressBar,
            success = { response ->
                binding.groupVacanciesAndOffers.isVisible = true
                binding.groupAllVacancies.isVisible = false
                val vacanciesCount = response.vacancies.size
                binding.btnMoreVacancies.text = "Еще $vacanciesCount ${
                    resources.getQuantityString(
                        com.example.core_ui.R.plurals.vacancy, vacanciesCount
                    )
                }"
                offerAdapter.items = response.offers
                vacancyAdapter.items = response.vacancies.take(3)
                binding.tvVacanciesCount.text = "$vacanciesCount ${
                    resources.getQuantityString(
                        com.example.core_ui.R.plurals.vacancy,
                        vacanciesCount
                    )
                }"
                viewModel.allVacancies = response.vacancies
            },
            error = { message ->
                showToast(message)
            },
        )

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.showAllVacancies.collect { showAllVacancies ->
                showAllVacancies?.let {
                    if (showAllVacancies) {
                        binding.groupAllVacancies.isVisible = true
                        binding.groupVacanciesAndOffers.isVisible = false
                        binding.root.smoothScrollTo(0, 0)
                        vacancyAdapter.items = viewModel.allVacancies
                    } else {
                        binding.groupAllVacancies.isVisible = false
                        binding.groupVacanciesAndOffers.isVisible = true
                        vacancyAdapter.items = viewModel.allVacancies.take(3)
                    }
                }
            }
        }
    }

    private fun onFavoriteClick(vacancy: Vacancy) {
        viewModel.toFavorite(vacancy)
    }

    private fun onVacancyItemCLick() {
        findNavController().safeNavigation(R.id.action_searchFragment_to_vacancyFragment)
    }
}