package com.nsystem.materialmotion

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), MainNavigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponentListFragment()
    }

    override fun onContainerTransformFragmentClicked(view: View) {
        loadFragment(
            ContainerTransformFragment(),
            getString(R.string.shared_container_to_fragment),
            view
        )
    }

    override fun onBackPressed() {
        supportFragmentManager.popBackStack()
    }

    private fun initComponentListFragment() {
        loadFragment(ComponentListFragment().apply {
            setMainNavigation(this@MainActivity)
        })
    }

    private fun loadFragment(
        fragment: Fragment,
        sharedElementName: String = "",
        view: View? = null
    ) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fl_component_list, fragment)
            .apply {
                if (view != null && sharedElementName.isNotBlank()) {
                    this.addSharedElement(view, sharedElementName)
                }
            }
            .commit()
    }
}