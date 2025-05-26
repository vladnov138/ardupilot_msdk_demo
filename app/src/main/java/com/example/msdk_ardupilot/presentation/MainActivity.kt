package com.example.msdk_ardupilot.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.msdk_ardupilot.BuildConfig
import com.example.msdk_ardupilot.R
import com.example.msdk_ardupilot.databinding.ActivityMainBinding
import com.yandex.mapkit.MapKitFactory


class MainActivity : AppCompatActivity() {
    private var _viewBinding: ActivityMainBinding? = null
    private val binding get() = _viewBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val bottomNavView = binding.bottomNavigationView
        val navController = navHostFragment.navController
        bottomNavView.setupWithNavController(navController)

        MapKitFactory.setApiKey(BuildConfig.MAPKIT_API_KEY)
    }
}