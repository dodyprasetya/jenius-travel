package com.jenius.travel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_travel.view.*

class TravelAdapter(val listDestination: ArrayList<Destination>) : RecyclerView.Adapter<TravelAdapter.TravelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_travel, parent, false)
        return TravelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDestination.size
    }

    override fun onBindViewHolder(holder: TravelViewHolder, position: Int) {
        holder.bind()
    }

    inner class TravelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind() {
            val destination = listDestination[adapterPosition]
            itemView.textDestination.text = destination.name
            itemView.textDays.text = "${destination.days} days"

            if (destination.isFeatured) itemView.textFeatured.visibility = View.VISIBLE
            else itemView.textFeatured.visibility = View.GONE
        }
    }
}