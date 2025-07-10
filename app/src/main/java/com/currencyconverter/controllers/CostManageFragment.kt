package com.currencyconverter.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
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

        btnSetBudget.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            val input = EditText(requireContext())
            builder.setTitle("Set Your Budget")
            builder.setView(input)

            builder.setPositiveButton("OK") { dialog, _ ->
                val budget = input.text.toString()
                tvBalance.text = budget // Update the balance TextView
                dialog.dismiss()
            }
            builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }

            builder.show()
        }
    }
}