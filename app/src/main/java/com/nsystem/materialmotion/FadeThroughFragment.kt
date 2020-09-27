package com.nsystem.materialmotion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialFadeThrough
import com.nsystem.materialmotion.databinding.FragmentFadeThroughBinding


/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version FadeThroughActivity, v 0.0.1 27/09/20 17.36 by Putra Nugraha
 */
class FadeThroughFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = MaterialFadeThrough()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentFadeThroughBinding.inflate(inflater, container, false).root
}