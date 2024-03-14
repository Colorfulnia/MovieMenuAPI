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
    private lateinit var upcomingFragment: UpcomingFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        nowPlayingFragment = NowPlayingFragment()
        popularFragment = PopularFragment()
        upcomingFragment = UpcomingFragment()

        binding.bottomMenu.setOnNavigationItemSelectedListener {
            it->
            when (it.itemId) {
                R.id.navigation_now_playing -> {
                    openFragment(nowPlayingFragment)
                }
                R.id.navigation_popular -> {
                    openFragment(popularFragment)
                }
                R.id.navigation_upcoming -> {
                    openFragment(upcomingFragment)
                }
            }
            true
        }
        openFragment(nowPlayingFragment)
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}

