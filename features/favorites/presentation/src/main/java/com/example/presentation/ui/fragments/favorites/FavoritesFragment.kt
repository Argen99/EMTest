package com.example.presentation.ui.fragments.favorites

import android.annotation.SuppressLint
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.model.Vacancy
import com.example.core_ui.base.BaseFragment
import com.example.presentation.R
import com.example.presentation.databinding.FragmentFavoritesBinding
import com.example.presentation.ui.adapters.MainAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesFragment :
    BaseFragment<FragmentFavoritesBinding, FavoritesViewModel>(R.layout.fragment_favorites) {

    override val binding by viewBinding(FragmentFavoritesBinding::bind)
    override val viewModel by viewModel<FavoritesViewModel>()

    private val favoritesAdapter: MainAdapter by lazy {
        MainAdapter(
            context = requireContext(),
            onFavoriteClick = ::onFavoriteClick
        )
    }

    override fun initialize() {
        binding.rvFavorites.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = favoritesAdapter
        }
    }

    @SuppressLint("SetTextI18n")
    override fun launchObservers() {
        viewModel.favoritesState.spectateUiState(
            success = {
                favoritesAdapter.items = it
                binding.tvVacanciesCount.text = "${it.size} ${
                    resources.getQuantityString(com.example.core_ui.R.plurals.vacancy, it.size)}"
            }
        )
    }

    private fun onFavoriteClick(vacancy: Vacancy) {
        viewModel.toFavorite(vacancy)
    }
}