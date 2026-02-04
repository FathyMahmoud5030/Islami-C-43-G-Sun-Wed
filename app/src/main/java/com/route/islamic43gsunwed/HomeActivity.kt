package com.route.islamic43gsunwed

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.route.islamic43gsunwed.databinding.ActivityHomeBinding
import com.route.islamic43gsunwed.fragments.hadeth.HadethFragment
import com.route.islamic43gsunwed.fragments.quran.QuranFragment
import com.route.islamic43gsunwed.fragments.RadioFragment
import com.route.islamic43gsunwed.fragments.TasbeehFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) { // R.id.navigation_quran
                R.id.navigation_quran -> {

                    pushFragment(QuranFragment())
                }

                R.id.navigation_radio -> {
                    pushFragment(RadioFragment())
                }

                R.id.navigation_hadeth -> {
                    pushFragment(HadethFragment())
                }

                R.id.navigation_tasbeeh -> {
                    pushFragment(TasbeehFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
        binding.bottomNavigationView.selectedItemId = R.id.navigation_quran
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.islamiFragmentContainer.id, fragment)
            .commit()
    }

}