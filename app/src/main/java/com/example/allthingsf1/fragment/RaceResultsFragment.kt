package com.example.allthingsf1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.allthingsf1.R

/**
 * A simple [Fragment] subclass.
 */
class RaceResultsFragment : Fragment() {

    private lateinit var fragmentView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.fragment_race_results, container, false)
        return fragmentView
    }

}
