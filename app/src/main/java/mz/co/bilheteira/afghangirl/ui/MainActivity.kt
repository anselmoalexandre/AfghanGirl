package mz.co.bilheteira.afghangirl.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import mz.co.bilheteira.afghangirl.R
import mz.co.bilheteira.afghangirl.ui.viewmodel.HomeViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var backPressOnce: Boolean = false

    // Binding


    private val viewModel: HomeViewModel by viewModels()
    // NavHost
    private val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.nav_host_fragment) }

    // NavController
    private val navController by lazy { (navHostFragment as NavHostFragment).navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        // Setting up the Action bar
        setupAppBar(navController = navController)

        // Setting up the Bottom Navigation using Navigation Component
        val bottomNav = findViewById<BottomNavigationView>(R.id.main_nav)
        setupBottomNav(navController = navController, bottomNav = bottomNav)

        // Hide bottom navigation on destinations that it's not needed
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.destination_home, R.id.destination_explore, R.id.destination_info -> {
                    bottomNav.visibility = View.VISIBLE
                }
                else -> {
                    bottomNav.visibility = View.GONE
                }
            }
        }
    }

    /**
     * Setup the Bottom Navigation View
     * [navController] Navigation Controller
     * [bottomNav] Bottom Navigation View
     */
    private fun setupBottomNav(navController: NavController, bottomNav: BottomNavigationView) {
        bottomNav.setupWithNavController(navController)
    }

    /**
     * Setup Action bar with Navigation Controller
     * Removing the back arrow in the main destinations of the Afghan girl app
     * [navController] Navigation Controller
     */
    private fun setupAppBar(navController: NavController) {
        //  Pass the IDs of top-level destinations in the AppBarConfiguration
        val appBarConfig = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.destination_home,
                R.id.destination_explore,
                R.id.destination_info
            )
        )
        setupActionBarWithNavController(navController, appBarConfig)
    }

    // Quit Afghan girl app on twice back press
    override fun onBackPressed() {
        // Check if the current destination is actually the start destination - Home destination
        if (navController.graph.startDestination == navController.currentDestination?.id) {
            // Check if back is already pressed. If yes, then exit the app.
            if (backPressOnce) {
                super.onBackPressed()
                return
            }

            backPressOnce = true

            // Launching a Kotlin Coroutine to hold a 2s
            lifecycleScope.launch(Dispatchers.Default) {
                delay(2000L)
                withContext(Dispatchers.Main) {
                    backPressOnce = false
                }
            }
        } else {
            super.onBackPressed()
        }
    }
}