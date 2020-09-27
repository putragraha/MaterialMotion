package com.nsystem.materialmotion.containertransform

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.nsystem.materialmotion.R

class ContainerTransformActivity : AppCompatActivity(), ContainerTransformNavigation {

    companion object {

        const val COMPONENT_LIST_FRAGMENT_TAG = "COMPONENT_LIST_FRAGMENT_TAG"

        const val CONTAINER_TRANSFORMED_FRAGMENT_TAG = "CONTAINER_TRANSFORMED_FRAGMENT_TAG"

        const val MINIMUM_ACTIVE_FRAGMENT = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setupContainerTransformToActivity()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container_transform)
        initComponentListFragment()
    }

    override fun onContainerTransformFragmentClicked(view: View) {
        loadFragment(
            ContainerTransformedFragment(),
            getString(R.string.shared_container_to_fragment),
            view,
            CONTAINER_TRANSFORMED_FRAGMENT_TAG
        )
    }

    override fun onContainerTransformActivityClicked(view: View) {
        startActivity(
            Intent(this, ContainerTransformedActivity::class.java),
            ActivityOptions.makeSceneTransitionAnimation(
                this,
                view,
                getString(R.string.shared_container_to_activity)
            ).toBundle()
        )
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > MINIMUM_ACTIVE_FRAGMENT) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }

    private fun setupContainerTransformToActivity() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false
    }

    private fun initComponentListFragment() {
        loadFragment(
            ContainerTransformListFragment().apply {
                setMainNavigation(this@ContainerTransformActivity)
            },
            fragmentTag = COMPONENT_LIST_FRAGMENT_TAG
        )
    }

    private fun loadFragment(
        fragment: Fragment,
        sharedElementName: String = "",
        view: View? = null,
        fragmentTag: String
    ) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(fragmentTag)
            .replace(R.id.fl_component_list, fragment)
            .apply {
                if (view != null && sharedElementName.isNotBlank()) {
                    this.addSharedElement(view, sharedElementName)
                }
            }
            .commit()
    }
}