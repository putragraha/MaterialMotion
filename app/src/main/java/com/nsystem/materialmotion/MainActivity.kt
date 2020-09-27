package com.nsystem.materialmotion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.nsystem.materialmotion.containertransform.ContainerTransformActivity
import com.nsystem.materialmotion.databinding.ActivityMainBinding
import com.nsystem.materialmotion.sharedaxis.SharedAxisActivity

class MainActivity : AppCompatActivity(), MainNavigation {

    companion object {

        const val MAIN_FRAGMENT_TAG = "MAIN_FRAGMENT_TAG"

        const val FADE_THROUGH_FRAGMENT_TAG = "FADE_THROUGH_FRAGMENT_TAG"

        const val MINIMUM_ACTIVE_FRAGMENT = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
        initMainFragment()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > MINIMUM_ACTIVE_FRAGMENT) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }

    override fun onContainerTransformClicked() {
        startActivity(Intent(this@MainActivity, ContainerTransformActivity::class.java))
    }

    override fun onSharedAxisClicked() {
        startActivity(Intent(this@MainActivity, SharedAxisActivity::class.java))
    }

    override fun onFadeThroughClicked() {
        loadFragment(FadeThroughFragment(), FADE_THROUGH_FRAGMENT_TAG)
    }

    private fun initMainFragment() {
        loadFragment(
            MainFragment().apply { setMainNavigation(this@MainActivity) },
            MAIN_FRAGMENT_TAG
        )
    }

    private fun loadFragment(fragment: Fragment, fragmentTag: String) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(fragmentTag)
            .replace(R.id.cl_container, fragment)
            .commit()
    }
}