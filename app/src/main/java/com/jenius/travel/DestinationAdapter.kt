package com.jenius.travel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DestinationAdapter : RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_destination, parent, false)
        return DestinationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
    }

    inner class DestinationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}