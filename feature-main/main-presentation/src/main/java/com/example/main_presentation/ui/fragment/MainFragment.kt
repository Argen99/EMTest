package com.example.main_presentation.ui.fragment

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.model.Course
import com.example.core_ui.base.BaseFragment
import com.example.core_ui.extesions.safeNavigation
import com.example.core_ui.extesions.showToast
import com.example.main_presentation.R
import com.example.main_presentation.databinding.FragmentMainBinding
import com.example.main_presentation.ui.adapter.CoursesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main) {

    override val binding by viewBinding(FragmentMainBinding::bind)
    override val viewModel by viewModel<MainViewModel>()
    private val coursesAdapter: CoursesAdapter by lazy {
        CoursesAdapter(::onItemClick, ::onFavoriteClick)
    }

    override fun initialize() {
        binding.rvCourse.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = coursesAdapter
        }
    }

    override fun setupListeners(): Unit = with(binding) {
        tvSort.setOnClickListener {
            viewModel.sortCoursesByPublishDate()
        }
    }

    override fun launchObservers() {
        viewModel.coursesState.spectateUiState(
            progressBar = binding.progressBar,
            success = {
                coursesAdapter.submitList(it)
            },
            error = {
                showToast(it)
            }
        )
    }

    private fun onItemClick(item: Course) {
        findNavController()
            .safeNavigation(MainFragmentDirections.actionMainFragmentToCourseInfoFragment(item))
    }

    private fun onFavoriteClick(item: Course) {
        viewModel.onFavoriteClick(item)
    }

    override fun onResume() {
        super.onResume()
        viewModel.getCourses()
    }
}