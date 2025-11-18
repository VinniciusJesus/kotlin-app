package com.streaming.android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.streaming.android.R
import com.streaming.android.ui.feed.FeedFragment
import com.streaming.android.ui.playlists.PlaylistsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.bottom_navigation)
        
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_feed -> {
                    replaceFragment(FeedFragment())
                    true
                }
                R.id.nav_playlists -> {
                    replaceFragment(PlaylistsFragment())
                    true
                }
                else -> false
            }
        }

        // Fragment inicial
        if (savedInstanceState == null) {
            replaceFragment(FeedFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}


