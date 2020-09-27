package com.nsystem.materialmotion.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.nsystem.materialmotion.R
import com.nsystem.materialmotion.main.fragment.ComponentListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponentListFragment()
    }

    private fun initComponentListFragment() {
        loadFragment(ComponentListFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_component_list, fragment)
            .commit()
    }
}