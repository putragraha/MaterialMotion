package com.nsystem.materialmotion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nsystem.materialmotion.containertransform.ContainerTransformActivity
import com.nsystem.materialmotion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButton()
    }

    private fun setupButton() {
        binding.mbContainerTransform.setOnClickListener {
            startActivity(Intent(this@MainActivity, ContainerTransformActivity::class.java))
        }
    }
}