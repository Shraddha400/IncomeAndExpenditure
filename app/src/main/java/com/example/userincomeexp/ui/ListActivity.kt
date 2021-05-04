package com.example.userincomeexp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.userincomeexp.R
import com.example.userincomeexp.expenditure.ExpenditureFragment
import com.example.userincomeexp.income.IncomeFragment
import com.google.android.material.tabs.TabLayout

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        var viewPager = findViewById<ViewPager>(R.id.viewPager)
        var tablayout = findViewById<TabLayout>(R.id.tablayout)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(IncomeFragment(),"Income")
        fragmentAdapter.addFragment(ExpenditureFragment(),"Expenditure")

        viewPager.adapter = fragmentAdapter
        tablayout.setupWithViewPager(viewPager)
    }
}