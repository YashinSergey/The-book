package com.example.thebook.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.os.Bundle
import com.example.thebook.R

import com.example.thebook.fragments.TitleFragment

import io.reactivex.Single


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var titleFragment: TitleFragment
    var singleTitle: Single<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragments(savedInstanceState)

    }

    private fun initFragments(savedInstanceState: Bundle?) {
        titleFragment = TitleFragment()
        if (savedInstanceState == null) {
            replaceFragment(titleFragment)
        }
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container_for_fragments, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
