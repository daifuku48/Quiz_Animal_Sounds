package com.luadanilkarit.quiz_animalsounds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.luadanilkarit.quiz_animalsounds.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController : NavController
    private var _binding : ActivityMainBinding? = null
    private val binding
        get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.main_activity) as NavHostFragment
        navController = navHost.navController

    }

    override fun onSupportNavigateUp(): Boolean {
        return (navController.navigateUp()) || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}