package com.example.userincomeexp.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import com.example.userincomeexp.R
import com.example.userincomeexp.expenditure.Expenditure
import com.example.userincomeexp.income.Income
import com.example.userincomeexp.utils.SharedPreference
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    var incomeEdit: EditText? = null
    var expenditureEdit: EditText? = null
    var incomeList: ArrayList<Income> = arrayListOf()
    var expenditureList: ArrayList<Expenditure> = arrayListOf()
    lateinit var sharedPreferences: SharedPreference

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        incomeEdit = findViewById(R.id.add_income)
        expenditureEdit = findViewById(R.id.add_expenditure)
        sharedPreferences = SharedPreference(this)
        val btnAddIncomeExpenditure = findViewById<Button>(R.id.add_another_data)
        btnAddIncomeExpenditure.setOnClickListener {
            getIncomeAndExpenditure()
            incomeEdit!!.setText("")
            expenditureEdit!!.setText("")
        }
        val button = findViewById<Button>(R.id.save_button)
        button.setOnClickListener {
            if (incomeList.size > 0 && expenditureList.size > 0) {
                incomeList.let { it1 -> sharedPreferences.storeIncome(it1) }
                expenditureList.let { it1 -> sharedPreferences.storeExpenditure(it1) }
            }
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getIncomeAndExpenditure() {
        val income = incomeEdit!!.text.toString().trim()
        val expenditure = expenditureEdit!!.text.toString().trim()
        val date = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd / HH:MM:SS")

        incomeList.add(Income(income = income.toInt(), date = date.format(formatter)))
        expenditureList.add(
            Expenditure(
                expenditure = expenditure.toInt(),
                date = date.format(formatter)
            )
        )

    }


}