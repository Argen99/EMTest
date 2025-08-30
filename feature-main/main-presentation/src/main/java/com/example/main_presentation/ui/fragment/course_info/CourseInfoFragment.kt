package com.example.main_presentation.ui.fragment.course_info

import androidx.core.view.WindowCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.core.model.Course
import com.example.core_ui.base.BaseFragment
import com.example.core_ui.extesions.asUri
import com.example.core_ui.extesions.openInBrowser
import com.example.core_ui.extesions.setUrlImage
import com.example.core_ui.utils.Constants
import com.example.core_ui.utils.ImageProvider
import com.example.main_presentation.R
import com.example.main_presentation.databinding.FragmentCourseInfoBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CourseInfoFragment :
    BaseFragment<FragmentCourseInfoBinding, CourseInfoViewModel>(R.layout.fragment_course_info) {

    override val binding by viewBinding(FragmentCourseInfoBinding::bind)
    override val viewModel by viewModel<CourseInfoViewModel>()
    private val navArgs by navArgs<CourseInfoFragmentArgs>()

    override fun initialize() {
        activity?.window?.let {
            WindowCompat.setDecorFitsSystemWindows(it, false)
        }
        setCourseData(navArgs.course)
        setFavoriteIcon(navArgs.course)
    }

    override fun setupListeners(): Unit = with(binding) {
        btnGoToPlatform.setOnClickListener {
            Constants.STEPIK_URL.asUri()?.openInBrowser(requireContext())
        }
        btnStartCourse.setOnClickListener {
            Constants.STEPIK_URL.asUri()?.openInBrowser(requireContext())
        }
        ivFavorite.setOnClickListener {
            navArgs.course.hasLike = !navArgs.course.hasLike
            viewModel.onFavoriteClick(navArgs.course)
            setFavoriteIcon(navArgs.course)
        }
        btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setCourseData(item: Course): Unit = with(binding) {
        tvTitle.text = item.title
        ivCover.setUrlImage(ImageProvider.getRandomImageUrl())
        tvRating.text = item.rate
        tvDate.text = item.publishDate
        tvDescription.text = item.text
        ivOwner.setUrlImage(ImageProvider.getRandomImageUrl())
        tvOwner.text = "Author"
    }

    private fun setFavoriteIcon(course: Course) {
        if (course.hasLike) {
            binding.ivFavorite.setImageResource(com.example.core_ui.R.drawable.ic_favorite_active)
        } else {
            binding.ivFavorite.setImageResource(com.example.core_ui.R.drawable.ic_favorite)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        activity?.window?.let {
            WindowCompat.setDecorFitsSystemWindows(it, true)
        }
    }
}