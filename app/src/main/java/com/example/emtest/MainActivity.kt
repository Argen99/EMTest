package com.example.emtest

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.emtest.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_app) as NavHostFragment
        val navController = navHostFragment.navController
        setupBottomNavigation(navController)
    }

    private fun setupBottomNavigation(navController: NavController): Unit = with(binding) {
        bottomNavView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                com.example.main_presentation.R.id.mainFragment,
                com.example.favorites_presentation.R.id.favoritesFragment,
                com.example.account_presentation.R.id.profileFragment,
                    -> bottomNavView.isVisible = true
                else -> bottomNavView.visibility = View.GONE
            }
        }
    }
}