package com.nsystem.materialmotion.sharedaxis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialSharedAxis
import com.nsystem.materialmotion.databinding.FragmentSharedXAxisTransformedBinding
import com.nsystem.materialmotion.databinding.FragmentSourceSharedAxisBinding


/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version SourceSharedAxisFragment, v 0.0.1 27/09/20 16.06 by Putra Nugraha
 */
class SharedXAxisTransformedFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSharedXAxisTransformedBinding
            .inflate(inflater, container, false)
            .root
    }
}