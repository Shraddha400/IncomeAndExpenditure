package com.example.userincomeexp.expenditure

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.userincomeexp.R
import java.text.MessageFormat


class ExpenditureAdapter (private val expAmount: ArrayList<Expenditure>) :
    RecyclerView.Adapter<ExpenditureAdapter.ExpenditureViewHolder>() {

    class ExpenditureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val expAmount1 = itemView.findViewById<TextView>(R.id.income_amount)
        val date = itemView.findViewById<TextView>(R.id.income_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenditureViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_income, parent, false)
        return ExpenditureViewHolder(view)

    }

    override fun onBindViewHolder(holder: ExpenditureViewHolder, position: Int) {
        val expenditure = expAmount[position]
        val incomeData = expenditure.expenditure.toString()
        holder.expAmount1.text = MessageFormat.format("Rs: {0}", incomeData)
      holder.date.text = expenditure.date.toString()
    }

    override fun getItemCount(): Int {
        return expAmount.size
    }

}