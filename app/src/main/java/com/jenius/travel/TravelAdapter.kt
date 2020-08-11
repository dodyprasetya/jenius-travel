package com.jenius.travel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_travel.view.*

class TravelAdapter(val listDestination: ArrayList<Destination>) : RecyclerView.Adapter<TravelAdapter.TravelViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelViewHolder {
        context = parent.context
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

            // hide and show featured text
            if (destination.isFeatured) itemView.textFeatured.visibility = View.VISIBLE
            else itemView.textFeatured.visibility = View.GONE

            // set click listener on list
            itemView.listContainer.setOnClickListener {
                Toast.makeText(context, "${destination.name} is clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}