package com.jenius.travel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = intent.getStringExtra("username")

        val bundle = Bundle()
        bundle.putString("username", username)

        val profileFragment = ProfileFragment()
        profileFragment.arguments = bundle

        replaceFragment(profileFragment)

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuProfile -> {
                    replaceFragment(profileFragment)
                    true
                }
                R.id.menuTravelList -> {
                    replaceFragment(TravelListFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }
}