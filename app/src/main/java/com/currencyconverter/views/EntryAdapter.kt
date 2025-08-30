package com.currencyconverter.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.currencyconverter.R
import com.currencyconverter.models.EntryItem

class EntryAdapter(private val entries: MutableList<EntryItem>) : RecyclerView.Adapter<EntryAdapter.EntryViewHolder>() {
    class EntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val amountTextView: TextView = itemView.findViewById(R.id.amountTextView)
        val reasonTextView: TextView = itemView.findViewById(R.id.reasonTextView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_invoices, parent, false)
        return EntryViewHolder(view)
    }
    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val entry = entries[position]
        holder.amountTextView.text = "${if (entry.entryType == "Income") "+" else "-"}${entry.amount}$"
        holder.reasonTextView.text = entry.reason
        // You can add a date property to EntryItem if needed
        holder.dateTextView.text = "" // Set date if available
    }

    override fun getItemCount(): Int = entries.size
}