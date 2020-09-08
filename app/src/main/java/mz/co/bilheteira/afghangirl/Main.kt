package mz.co.bilheteira.afghangirl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class Main : AppCompatActivity() {
    // NavHost
    private val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.nav_host_fragment) }

    // NavController
    private val navController by lazy { (navHostFragment as NavHostFragment).navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        // Setting up the Bottom Navigation using Navigation Component
        val bottomNav = findViewById<BottomNavigationView>(R.id.main_nav)
        setupBottomNav(navController = navController, bottomNav = bottomNav)

        // Setting up the Action bar
        setupAppBar(navController = navController)
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
     * Setup the Navigation View
     * [navController] Navigation Controller
     * [navView] Navigation View
     */
    private fun setupDrawerLayout(navController: NavController, navView: NavigationView) {
        navView.setupWithNavController(navController)
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
                R.id.destination_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfig)
    }
}