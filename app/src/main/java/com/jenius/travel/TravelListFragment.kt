package com.jenius.travel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_travel_list.*

class TravelListFragment : Fragment() {

    private val listDestination = ArrayList<Destination>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_travel_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // adding data
        listDestination.add(Destination("Tokyo, Japan", 6, true))
        listDestination.add(Destination("Paris, France", 7, false))
        listDestination.add(Destination("Bali, Indonesia", 10, false))
        listDestination.add(Destination("Phuket Island", 3, true))
        listDestination.add(Destination("Maldives", 30, true))
        listDestination.add(Destination("Hong Kong", 2, false))

        recyclerView.adapter = TravelAdapter(listDestination)
    }
}