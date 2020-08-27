package com.jenius.travel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import kotlinx.android.synthetic.main.fragment_travel_list.*


class TravelListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_travel_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        swipeRefreshLayout.post {
            request()
        }

        swipeRefreshLayout.setOnRefreshListener {
            request()
        }
    }

    private fun request(){
        swipeRefreshLayout.isRefreshing = true
        AndroidNetworking.get("https://thesimplycoder.herokuapp.com/travel-bucket")
            .build()
            .getAsObjectList(Destination::class.java, object : ParsedRequestListener<List<Destination>> {
                override fun onResponse(response: List<Destination>?) {
                    recyclerView.adapter = TravelAdapter(response!!)
                    swipeRefreshLayout.isRefreshing = false
                }

                override fun onError(anError: ANError?) {
                    Toast.makeText(activity, anError!!.message, Toast.LENGTH_SHORT).show()
                    swipeRefreshLayout.isRefreshing = false
                }
            })
    }
}