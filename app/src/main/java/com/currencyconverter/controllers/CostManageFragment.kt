package com.currencyconverter.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.currencyconverter.R
import com.currencyconverter.models.EntryItem
import com.currencyconverter.views.EntryAdapter

class CostManageFragment : Fragment(R.layout.fragment_cost_manage) {
    private lateinit var tvLabel: TextView
    private lateinit var tvBalance: TextView
    private lateinit var rvEntries: RecyclerView
    private lateinit var btnAddEntry: Button
    private lateinit var btnSetBudget: Button
    private val entryList = mutableListOf<EntryItem>()
    private lateinit var entryAdapter: EntryAdapter

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

        btnAddEntry.setOnClickListener {
            val options = arrayOf("Income", "Outcome")
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Select Entry Type")
            builder.setItems(options) { dialog, which ->
                val entryType = if (which == 0) "Income" else "Outcome"
                val entryDialog = AlertDialog.Builder(requireContext())
                entryDialog.setTitle("Add $entryType")

                // Create a vertical LinearLayout to hold the EditTexts
                val layout = LinearLayout(requireContext())
                layout.orientation = LinearLayout.VERTICAL
                val amountInput = EditText(requireContext())
                amountInput.hint = "Amount"
                amountInput.inputType = android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
                val reasonInput = EditText(requireContext())
                reasonInput.hint = "Reason"
                layout.addView(amountInput)
                layout.addView(reasonInput)
                entryDialog.setView(layout)

                entryDialog.setPositiveButton("Add") { entryDialogInterface, _ ->
                    val amount = amountInput.text.toString().toDoubleOrNull()
                    val reason = reasonInput.text.toString()

                    if (amount != null && reason.isNotBlank()) {
                        val entry = EntryItem(amount, reason, entryType)
                        entryList.add(entry)
                        entryAdapter.notifyItemInserted(entryList.size - 1)
                    }

                    entryDialogInterface.dismiss()
                }
                entryDialog.setNegativeButton("Cancel") { entryDialogInterface, _ -> entryDialogInterface.cancel() }
                entryDialog.show()
                dialog.dismiss()
            }
            builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }
            builder.show()
        }
    }
}