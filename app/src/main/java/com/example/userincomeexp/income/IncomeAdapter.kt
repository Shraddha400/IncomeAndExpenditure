package com.example.userincomeexp.income

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userincomeexp.R
import java.text.MessageFormat

class IncomeAdapter(
    private val mContext: Context,
    private val incomes: ArrayList<Income>
) :
    RecyclerView.Adapter<IncomeAdapter.IncomeViewHolder>() {

    class IncomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val incomeAmount = itemView.findViewById<TextView>(R.id.income_amount)
        val date = itemView.findViewById<TextView>(R.id.income_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_income, parent, false)
        return IncomeViewHolder(view)

    }

    override fun onBindViewHolder(holder: IncomeViewHolder, position: Int) {
        val income = incomes[position]
        val incomeData = income.income.toString()
        holder.incomeAmount.text = MessageFormat.format("Rs: {0}", incomeData)
        holder.date.text = income.date.toString()
    }

    override fun getItemCount(): Int {
        return incomes.size
    }

}