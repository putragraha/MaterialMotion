package com.nsystem.materialmotion.sharedaxis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialSharedAxis
import com.nsystem.materialmotion.databinding.FragmentSourceSharedAxisBinding


/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version SourceSharedAxisFragment, v 0.0.1 27/09/20 16.06 by Putra Nugraha
 */
class SourceSharedAxisFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reenterTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSourceSharedAxisBinding.inflate(inflater, container, false).root
    }
}