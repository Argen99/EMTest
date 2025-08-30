package com.example.favorites_presentation.ui.fragment

import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.model.Course
import com.example.core_ui.base.BaseFragment
import com.example.core_ui.extesions.showToast
import com.example.favorites_presentation.R
import com.example.favorites_presentation.databinding.FragmentFavoritesBinding
import com.example.favorites_presentation.ui.adapter.FavoritesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding, FavoritesViewModel>(R.layout.fragment_favorites) {

    override val binding by viewBinding(FragmentFavoritesBinding::bind)
    override val viewModel by viewModel<FavoritesViewModel>()
    private val favoritesAdapter: FavoritesAdapter by lazy {
        FavoritesAdapter( {}, ::onFavoriteClick)
    }

    override fun initialize() {
        binding.rvFavorites.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = favoritesAdapter
        }
    }

    override fun launchObservers() {
        viewModel.favoritesState.spectateUiState(
            success = { favorites ->
                binding.tvPlaceHolder.isVisible = favorites.isEmpty()
                favoritesAdapter.submitList(favorites)
            },
            error = { message ->
                showToast(message)
            }
        )
    }

    private fun onFavoriteClick(course: Course) {
        viewModel.onFavoriteClick(course)
    }
}