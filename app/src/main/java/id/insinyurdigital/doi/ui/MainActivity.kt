package id.insinyurdigital.doi.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.insinyurdigital.doi.R
import id.insinyurdigital.doi.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navView: BottomNavigationView = binding.navView

//        val navController = findNavController(R.id.nav_host_fragment_activity_main2)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)

        val navFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment_activity_main2
        ) as NavHostFragment

        NavigationUI.setupWithNavController(binding.navView, navFragment.navController)

        navFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_dashboard -> setBottomNavVisibility(View.VISIBLE)
                R.id.navigation_home -> setBottomNavVisibility(View.VISIBLE)
                R.id.navigation_notifications -> setBottomNavVisibility(View.VISIBLE)
                else -> setBottomNavVisibility(View.GONE)
            }
        }
    }

    fun setTitle(title: String) {
        binding.tvTitle.text = title
    }

    private fun setBottomNavVisibility(visibility: Int) {
        binding.navView.visibility = visibility
    }
}