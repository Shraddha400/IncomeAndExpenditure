package com.example.userincomeexp.income

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userincomeexp.R
import com.example.userincomeexp.utils.SharedPreference

class IncomeFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var sharedPreference: SharedPreference? = null
    private var incomeList: ArrayList<Income>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreference = SharedPreference(requireContext())
        incomeList = sharedPreference!!.getIncome()
        incomeList!!.sortByDescending { it.date }
        Log.d("IncomeFragment", "onCreate: incomeListSize:: ${incomeList?.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_income, container, false)
        recyclerView = view.findViewById(R.id.income_recycler)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            adapter = IncomeAdapter(requireContext(), incomeList!!)
        }
        recyclerView!!.itemAnimator = DefaultItemAnimator()

        // adding inbuilt divider line
        recyclerView!!.addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))


        // Inflate the layout for this fragment
        return view
    }

}