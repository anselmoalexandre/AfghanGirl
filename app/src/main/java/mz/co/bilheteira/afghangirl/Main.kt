package mz.co.bilheteira.afghangirl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected
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
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return item.onNavDestinationSelected(navController)
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
     * [navController] Navigation Controller
     */
    private fun setupAppBarLayout(navController: NavController) {
        setupActionBarWithNavController(navController)
    }
}