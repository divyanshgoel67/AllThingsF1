package com.example.allthingsf1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.allthingsf1.R
import com.example.allthingsf1.recyclerview.SeasonRaceResultsRecyclerViewAdapter
import com.example.allthingsf1.viewmodel.RaceResultsViewModel
import kotlinx.android.synthetic.main.fragment_race_results.view.*

/**
 * A simple [Fragment] subclass.
 */
class RaceResultsFragment : Fragment() {

    private lateinit var fragmentView: View
    private lateinit var seasonText: TextView
    private lateinit var resultsRecyclerView: RecyclerView
    private lateinit var adapter: SeasonRaceResultsRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.fragment_race_results, container, false)
        initialiseViews()
        initialiseRaceResultsRecyclerView()
        var season = "2020"

        var raceResultsViewModel: RaceResultsViewModel =
            ViewModelProvider(this).get(RaceResultsViewModel::class.java)

        raceResultsViewModel.seasonRaceResultsData.observe(viewLifecycleOwner, Observer {
            adapter.updateRaceResultsList(it)
        })

        raceResultsViewModel.raceScheduleData.observe(viewLifecycleOwner, Observer {
            adapter.updateRaceScheduleList(it)
        })

        return fragmentView
    }

    private fun initialiseViews() {
//        seasonText = fragmentView.season_text
        val season = "2020"
//        seasonText.text = "Season $season"
        resultsRecyclerView = fragmentView.race_results_recycler_view
    }

    private fun initialiseRaceResultsRecyclerView() {
        adapter = SeasonRaceResultsRecyclerViewAdapter(requireContext())
        var layoutManager = LinearLayoutManager(requireContext())
        resultsRecyclerView.adapter = adapter
        resultsRecyclerView.layoutManager = layoutManager
    }

}
