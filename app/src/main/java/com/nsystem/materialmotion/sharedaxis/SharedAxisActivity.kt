package com.nsystem.materialmotion.sharedaxis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.nsystem.materialmotion.R


/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version SharedAxisActivity, v 0.0.1 27/09/20 15.54 by Putra Nugraha
 */
class SharedAxisActivity: AppCompatActivity() {

    companion object {

        const val SOURCE_SHARED_AXIS_FRAGMENT_TAG = "SOURCE_SHARED_AXIS_FRAGMENT_TAG"

        const val MINIMUM_ACTIVE_FRAGMENT = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_axis)
        initSourceSharedAxisFragment()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > MINIMUM_ACTIVE_FRAGMENT) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }

    private fun initSourceSharedAxisFragment() {
        loadFragment(SourceSharedAxisFragment(), SOURCE_SHARED_AXIS_FRAGMENT_TAG)
    }

    private fun loadFragment(fragment: Fragment, fragmentTag: String) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(fragmentTag)
            .replace(R.id.fl_unshared_element, fragment)
            .commit()
    }
}