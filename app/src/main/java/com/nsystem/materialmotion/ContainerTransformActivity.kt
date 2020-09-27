package com.nsystem.materialmotion

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback


/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ContainerTransformActivity, v 0.0.1 27/09/20 12.47 by Putra Nugraha
 */
class ContainerTransformActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setupTransformation()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container_transform)
    }

    private fun setupTransformation() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        findViewById<View>(android.R.id.content).transitionName = getString(R.string.shared_container_to_activity)
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementEnterTransition = MaterialContainerTransform().apply {
            addTarget(R.id.actv_title)
            duration = 300L
        }
        window.sharedElementReturnTransition = MaterialContainerTransform().apply {
            addTarget(R.id.actv_title)
            duration = 250L
        }
    }
}