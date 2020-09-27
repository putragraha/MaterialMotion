package com.nsystem.materialmotion.sharedaxis

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.transition.platform.MaterialSharedAxis
import com.nsystem.materialmotion.databinding.ActivitySharedAxisYTransformedBinding


/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version SharedAxisActivity, v 0.0.1 27/09/20 15.54 by Putra Nugraha
 */
class SharedAxisYTransformedActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySharedAxisYTransformedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySharedAxisYTransformedBinding.inflate(layoutInflater)

        setupSharedAxisYTransformForActivity()
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
    }

    private fun setupSharedAxisYTransformForActivity() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        window.enterTransition = MaterialSharedAxis(MaterialSharedAxis.Y, true).apply {
            addTarget(binding.clUnsharedElement)
        }
        window.returnTransition = MaterialSharedAxis(MaterialSharedAxis.Y, false).apply {
            addTarget(binding.clUnsharedElement)
        }
    }
}