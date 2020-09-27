package com.nsystem.materialmotion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialElevationScale
import com.nsystem.materialmotion.databinding.FragmentComponentListBinding


/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ComponentListFragment, v 0.0.1 26/09/20 23.48 by Putra Nugraha
 */
class ComponentListFragment: Fragment() {

    private lateinit var binding: FragmentComponentListBinding

    private lateinit var mainNavigation: MainNavigation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComponentListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        exitTransition = MaterialElevationScale(false)
        reenterTransition = MaterialElevationScale(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnMbFragmentClicked()
    }

    fun setMainNavigation(mainNavigation: MainNavigation) {
        this.mainNavigation = mainNavigation
    }

    private fun setOnMbFragmentClicked() {
        binding.mbToFragment.setOnClickListener {
            mainNavigation.onContainerTransformFragmentClicked(binding.mbToFragment)
        }
    }
}