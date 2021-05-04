package com.example.userincomeexp.expenditure

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userincomeexp.R
import com.example.userincomeexp.income.Income
import com.example.userincomeexp.income.IncomeAdapter
import com.example.userincomeexp.utils.SharedPreference

class ExpenditureFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var sharedPreference: SharedPreference? = null
    private var expenditureList: ArrayList<Expenditure>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreference = SharedPreference(requireContext())
        expenditureList = sharedPreference!!.getExpenditure()
        expenditureList!!.sortByDescending { it.date }
        Log.d("IncomeFragment", "onCreate: incomeListSize:: ${expenditureList?.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_expenditure, container, false)
        recyclerView = view.findViewById(R.id.exp_recycler)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            adapter = ExpenditureAdapter(expenditureList!!)
        }
        return view
    }

}
