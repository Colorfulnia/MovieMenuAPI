package com.tao.moviemenuapi.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tao.moviemenuapi.R
import com.tao.moviemenuapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var nowPlayingFragment: NowPlayingFragment
    private lateinit var popularFragment: PopularFragment
    private lateinit var topRatedFragment: TopRatedFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        nowPlayingFragment = NowPlayingFragment()
        popularFragment = PopularFragment()
        topRatedFragment = TopRatedFragment()

        binding.navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_now_playing -> {
                    openFragment(nowPlayingFragment)
                }
                R.id.navigation_popular -> {
                    openFragment(popularFragment)
                }
                R.id.navigation_top_rated -> {
                    openFragment(topRatedFragment)
                }
            }
            true
        }
        // Start with one fragment initially displayed
        openFragment(nowPlayingFragment)
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

