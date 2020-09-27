package com.nsystem.materialmotion

import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.platform.MaterialFade
import com.nsystem.materialmotion.databinding.FragmentMainBinding


/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version MainFragment, v 0.0.1 27/09/20 17.57 by Putra Nugraha
 */
class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding

    private lateinit var mainNavigation: MainNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = MaterialFadeThrough()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButton()
    }

    fun setMainNavigation(mainNavigation: MainNavigation) {
        this.mainNavigation = mainNavigation
    }

    private fun setupButton() {
        setupMbContainerTransform()
        setupMbSharedAxis()
        setupMbFadeThrough()
        setupMbFadeClicked()
        setupClFadeableViewClicked()
        setupOnMbBottomSheetClicked()
    }

    private fun setupMbContainerTransform() {
        binding.mbContainerTransform.setOnClickListener {
            mainNavigation.onContainerTransformClicked()
        }
    }

    private fun setupMbSharedAxis() {
        binding.mbSharedAxis.setOnClickListener {
            mainNavigation.onSharedAxisClicked()
        }
    }

    private fun setupMbFadeThrough() {
        binding.mbFadeThrough.setOnClickListener {
            mainNavigation.onFadeThroughClicked()
        }
    }

    private fun setupMbFadeClicked() {
        binding.mbFade.setOnClickListener {
            if (binding.clFadeableView.visibility == View.GONE) {
                fadeView(150L, View.VISIBLE)
            } else {
                fadeView(84L, View.GONE)
            }
        }
    }

    private fun setupClFadeableViewClicked( ) {
        binding.clFadeableView.setOnClickListener { fadeView(84L, View.GONE) }
    }

    private fun setupOnMbBottomSheetClicked() {
        binding.mbBottomSheet.setOnClickListener {
            mainNavigation.onBottomSheetClicked()
        }
    }

    private fun fadeView(duration: Long, visibility: Int) {
        val materialFade = MaterialFade().apply { this.duration = duration }
        TransitionManager.beginDelayedTransition(binding.clFadeableView, materialFade)
        binding.clFadeableView.visibility = visibility
    }
}