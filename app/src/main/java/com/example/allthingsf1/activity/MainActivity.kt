package com.example.allthingsf1.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.allthingsf1.DaggerRepositoryComponent
import com.example.allthingsf1.R
import com.example.allthingsf1.RepositoryManager
import com.example.f1repository.dagger.RepositoryModule
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
 
  private lateinit var navController: NavController
  private lateinit var appBarConfig: AppBarConfiguration
  private lateinit var drawerLayout: DrawerLayout
    private lateinit var displaySeason: String

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

      displaySeason = "2020"

      // Initialize repository component
      var repositoryComponent =
          DaggerRepositoryComponent.builder().repositoryModule(RepositoryModule(displaySeason))
              .build()
      RepositoryManager.instance.updateRepositoryComponent(repositoryComponent)

    val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    navController = navHostFragment.navController

//     Change default action bar to custom bar
    supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
    supportActionBar?.setDisplayShowCustomEnabled(true)
    supportActionBar?.setCustomView(R.layout.custom_toolbar)

    drawerLayout = findViewById(R.id.drawer_layout)

    appBarConfig = AppBarConfiguration(navController.graph, drawerLayout)
    navigation_view.setupWithNavController(navController)
    setupActionBarWithNavController(this, navController, appBarConfig)

  }

  override fun onSupportNavigateUp(): Boolean {
    val navController = findNavController(R.id.nav_host_fragment)
    return navController.navigateUp()
            || super.onSupportNavigateUp()
  }

    fun changeDisplaySeason(season: String) {
        updateRepositoryComponent(season)
    }

    private fun updateRepositoryComponent(season: String) {
        var repositoryComponent =
            DaggerRepositoryComponent.builder().repositoryModule(RepositoryModule(season)).build()
        RepositoryManager.instance.updateRepositoryComponent(repositoryComponent)
    }
}
