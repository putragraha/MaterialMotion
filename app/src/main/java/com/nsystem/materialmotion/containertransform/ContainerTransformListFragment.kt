package com.nsystem.materialmotion.containertransform

import android.graphics.Color
import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialElevationScale
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.nsystem.materialmotion.databinding.FragmentContainerTransformListBinding


/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ComponentListFragment, v 0.0.1 26/09/20 23.48 by Putra Nugraha
 */
class ContainerTransformListFragment: Fragment() {

    private lateinit var binding: FragmentContainerTransformListBinding

    private lateinit var containerTransformNavigation: ContainerTransformNavigation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContainerTransformListBinding.inflate(inflater, container, false)

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
        setOnMbActivityClicked()
        setOnMbViewClicked()
        setOnClTransformViewClicked()
    }

    fun setMainNavigation(containerTransformNavigation: ContainerTransformNavigation) {
        this.containerTransformNavigation = containerTransformNavigation
    }

    private fun setOnMbFragmentClicked() {
        binding.mbToFragment.setOnClickListener {
            containerTransformNavigation.onContainerTransformFragmentClicked(binding.mbToFragment)
        }
    }

    private fun setOnMbActivityClicked() {
        binding.mbToActivity.setOnClickListener {
            containerTransformNavigation.onContainerTransformActivityClicked(binding.mbToActivity)
        }
    }

    private fun setOnMbViewClicked() {
        binding.mbToView.setOnClickListener {
            transformView(binding.mbToView, binding.clViewTransform)
        }
    }

    private fun setOnClTransformViewClicked() {
        binding.clViewTransform.setOnClickListener {
            transformView(binding.clViewTransform, binding.mbToView)
        }
    }

    private fun transformView(sourceView: View, destinationView: View) {
        TransitionManager.beginDelayedTransition(
            binding.root,
            getMaterialContainerTransform(sourceView, destinationView)
        )
        sourceView.visibility = View.GONE
        destinationView.visibility = View.VISIBLE
    }

    private fun getMaterialContainerTransform(
        sourceView: View,
        destinationView: View
    ): MaterialContainerTransform {
        return MaterialContainerTransform().apply {
            startView = sourceView
            endView = destinationView
            addTarget(endView)
            pathMotion = MaterialArcMotion()
            scrimColor = Color.TRANSPARENT
        }
    }
}