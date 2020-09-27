package com.nsystem.materialmotion

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.nsystem.materialmotion.databinding.ActivityBottomSheetBinding


/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version BottomSheetActivity, v 0.0.1 27/09/20 19.25 by Putra Nugraha
 */

class BottomSheetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomSheetBinding

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        setupBottomSheetBehavior()
        setupOnMbBottomSheetClicked()
    }

    private fun setupBottomSheetBehavior() {
        bottomSheetBehavior = BottomSheetBehavior.from(binding.viewBottomSheet.clBottomSheet)
    }

    private fun setupOnMbBottomSheetClicked() {
        binding.mbBottomSheet.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }
}