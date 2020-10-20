package com.example.allthingsf1.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.allthingsf1.R
import com.example.allthingsf1.databinding.RaceResultsItemLayoutBinding
import com.example.models.raceresult.RaceResultsModel
import com.example.models.raceschedule.ScheduleEntityModel

class SeasonRaceResultsRecyclerViewAdapter(var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var raceResultsItemBinding: RaceResultsItemLayoutBinding
    private var raceResultList: List<RaceResultsModel> = ArrayList()
    private var raceScheduleList: List<ScheduleEntityModel> = ArrayList()

    companion object {
        const val RACE_RESULT_ITEM = 1
        const val RACE_SCHEDULE_ITEM = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {

            RACE_RESULT_ITEM -> {
                var raceResultsItemBinding = DataBindingUtil.inflate<RaceResultsItemLayoutBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.race_results_item_layout,
                    parent,
                    false
                )
                val view = raceResultsItemBinding.root
                RaceResultsViewHolder(view, raceResultsItemBinding, context)
            }

            else -> {
                val raceScheduleView = LayoutInflater.from(context)
                    .inflate(R.layout.race_schedule_item_layout, parent, false)
                RaceScheduleViewHolder(raceScheduleView, context)
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is RaceResultsModel -> {
                RACE_RESULT_ITEM
            }
            is ScheduleEntityModel -> {
                RACE_SCHEDULE_ITEM
            }
            else -> {
                -1
            }
        }
    }

    override fun getItemCount(): Int {
        return raceResultList.size + raceScheduleList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder.itemViewType) {
            RACE_RESULT_ITEM -> (holder as RaceResultsViewHolder).bind(item as RaceResultsModel)
            RACE_SCHEDULE_ITEM -> (holder as RaceScheduleViewHolder).bind(item as ScheduleEntityModel)
        }
    }

    private fun getItem(position: Int): Any? {
        return when {
            position < raceResultList.size -> return raceResultList[position]
            position < raceResultList.size + raceScheduleList.size -> return raceScheduleList[position - raceResultList.size]
            else -> null
        }
    }

    fun updateRaceResultsList(results: List<RaceResultsModel>) {
        this.raceResultList = results
        notifyDataSetChanged()
    }

    fun updateRaceScheduleList(results: List<ScheduleEntityModel>) {
        this.raceScheduleList = results
        notifyDataSetChanged()
    }

}


