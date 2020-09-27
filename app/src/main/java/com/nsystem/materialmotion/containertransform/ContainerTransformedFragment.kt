package com.nsystem.materialmotion.containertransform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialContainerTransform
import com.nsystem.materialmotion.R


/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version ComponentListFragment, v 0.0.1 26/09/20 23.48 by Putra Nugraha
 */
class ContainerTransformedFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_container_transformed, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = MaterialContainerTransform()
    }
}