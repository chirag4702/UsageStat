package com.example.usagestat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PackageAdapter : RecyclerView.Adapter<PackageAdapter.ViewHolder>() {

    private var packageNames: List<String> = emptyList()
    private var itemClickListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_package, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(packageNames[position])
    }

    override fun getItemCount(): Int {
        return packageNames.size
    }

    fun setData(data: List<String>) {
        packageNames = data
        notifyDataSetChanged()
    }

    fun setItemClickListener(listener: (String) -> Unit) {
        itemClickListener = listener
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val packageNameButton: Button = itemView.findViewById(R.id.packageNameButton)

        fun bind(packageName: String) {
            packageNameButton.text = packageName

            // Set click listener for the button
            packageNameButton.setOnClickListener {
                itemClickListener?.invoke(packageName)
            }
        }
    }
}

