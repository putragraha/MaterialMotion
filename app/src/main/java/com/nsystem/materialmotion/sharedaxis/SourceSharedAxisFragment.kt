package com.nsystem.materialmotion.sharedaxis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nsystem.materialmotion.databinding.FragmentSourceSharedAxisBinding


/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version SourceSharedAxisFragment, v 0.0.1 27/09/20 16.06 by Putra Nugraha
 */
class SourceSharedAxisFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSourceSharedAxisBinding.inflate(inflater, container, false).root
    }
}