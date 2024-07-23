package com.example.july_19.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.PopupMenu
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.july_19.R
import com.example.july_19.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fabButtonAction()
        navControllerFun()
    }

    private fun navControllerFun() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun fabButtonAction() {
        val fab: FloatingActionButton = binding.fab
        fab.setOnClickListener {
            showPopupMenu(fab)
        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.nav_drawer)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.getMethod -> {
                    navController.navigate(R.id.getAPiFragment)
                    supportActionBar?.title = "GET_API"
                    true
                }

                R.id.postMethod -> {
                    navController.navigate(R.id.postAPiFragment)
                    supportActionBar?.title = "POST_API"
                    true
                }

                R.id.putMethod -> {
                    navController.navigate(R.id.putAPiFragment)
                    supportActionBar?.title = "PUT_API"
                    true
                }

                R.id.patchMethod -> {
                    navController.navigate(R.id.patchAPiFragment)
                    supportActionBar?.title = "PATCH_API"
                    true
                }

                R.id.delete -> {
                    navController.navigate(R.id.deleteAPiFragment)
                    supportActionBar?.title = "DELETE"
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}

