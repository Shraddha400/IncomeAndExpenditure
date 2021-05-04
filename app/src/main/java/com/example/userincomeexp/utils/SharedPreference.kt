package com.example.userincomeexp.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.userincomeexp.expenditure.Expenditure
import com.example.userincomeexp.income.Income
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPreference(mContext: Context) {

    private val sharedPreference: SharedPreferences? =
        mContext.getSharedPreferences(Constants.NAME_SHARED_PREFERENCES, Context.MODE_PRIVATE)

    fun storeIncome(income: ArrayList<Income>) {
        sharedPreference!!.edit {
            putString(Constants.KEY_INCOME, Gson().toJson(income))
        }
    }

    fun storeExpenditure(expenditure: ArrayList<Expenditure>) {
        sharedPreference!!.edit {
            putString(Constants.KEY_EXPENDITURE, Gson().toJson(expenditure))
        }
    }

    fun getIncome(): ArrayList<Income> {
        val type = object : TypeToken<ArrayList<Income>?>() {}.type
        return Gson().fromJson(sharedPreference!!.getString(Constants.KEY_INCOME, null), type)
    }

    fun getExpenditure(): ArrayList<Expenditure> {
        val type = object : TypeToken<ArrayList<Expenditure>>() {}.type
        return Gson().fromJson(sharedPreference!!.getString(Constants.KEY_EXPENDITURE, null), type)
    }
}