package com.currencyconverter.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.currencyconverter.R

class CostManageFragment : Fragment(R.layout.fragment_cost_manage) {
    private lateinit var tvLabel: TextView
    private lateinit var tvBalance: TextView
    private lateinit var rvEntries: RecyclerView
    private lateinit var btnAddEntry: Button
    private lateinit var btnSetBudget: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvLabel = view.findViewById(R.id.tvLabel)
        tvBalance = view.findViewById(R.id.tvBalance)
        rvEntries = view.findViewById(R.id.rvEntries)
        btnAddEntry = view.findViewById(R.id.btnAddEntry)
        btnSetBudget = view.findViewById(R.id.btnSetBudget)
    }
}