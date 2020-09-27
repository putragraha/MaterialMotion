package com.nsystem.materialmotion.sharedaxis

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.transition.platform.MaterialSharedAxis
import com.nsystem.materialmotion.R
import com.nsystem.materialmotion.databinding.ActivitySharedAxisBinding


/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version SharedAxisActivity, v 0.0.1 27/09/20 15.54 by Putra Nugraha
 */
class SharedAxisActivity: AppCompatActivity() {

    companion object {

        const val SOURCE_SHARED_AXIS_FRAGMENT_TAG = "SOURCE_SHARED_AXIS_FRAGMENT_TAG"

        const val SHARED_X_AXIS_TRANSFORMED_FRAGMENT_TAG = "SHARED_X_AXIS_TRANSFORMED_FRAGMENT_TAG"

        const val MINIMUM_ACTIVE_FRAGMENT = 1
    }

    private lateinit var binding: ActivitySharedAxisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySharedAxisBinding.inflate(layoutInflater)

        setupSharedAxisYTransformForActivity()
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        initSourceSharedAxisFragment()
        setupButton()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > MINIMUM_ACTIVE_FRAGMENT) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }

    private fun setupSharedAxisYTransformForActivity() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        window.exitTransition = MaterialSharedAxis(MaterialSharedAxis.Y, true).apply {
            // Only run the transition on the contents of this activity, excluding
            // system bars or app bars if provided by the app’s theme.
            addTarget(binding.flUnsharedElement)
            excludeTarget(binding.mbYSharedAxis, false)
        }
        window.reenterTransition = MaterialSharedAxis(MaterialSharedAxis.Y, false).apply {
            addTarget(binding.flUnsharedElement)
            excludeTarget(binding.mbYSharedAxis, false)
        }
    }

    private fun initSourceSharedAxisFragment() {
        loadFragment(SourceSharedAxisFragment(), SOURCE_SHARED_AXIS_FRAGMENT_TAG)
    }

    private fun setupButton() {
        setupMbXSharedAxis()
        setupMbYSharedAxis()
    }

    private fun setupMbXSharedAxis() {
        binding.mbXSharedAxis.setOnClickListener {
            loadFragment(SharedXAxisTransformedFragment(), SHARED_X_AXIS_TRANSFORMED_FRAGMENT_TAG)
        }
    }

    private fun setupMbYSharedAxis() {
        binding.mbYSharedAxis.setOnClickListener {
            startActivity(Intent(
                this@SharedAxisActivity,
                SharedAxisYTransformedActivity::class.java)
            )
        }
    }

    private fun loadFragment(fragment: Fragment, fragmentTag: String) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(fragmentTag)
            .replace(R.id.fl_unshared_element, fragment)
            .commit()
    }
}