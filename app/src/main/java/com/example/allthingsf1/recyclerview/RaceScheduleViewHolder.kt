package com.example.allthingsf1.recyclerview

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.allthingsf1.R
import com.example.allthingsf1.Util
import com.example.models.raceschedule.ScheduleEntityModel

class RaceScheduleViewHolder(itemView: View, var context: Context) :
    RecyclerView.ViewHolder(itemView) {

    fun bind(results: ScheduleEntityModel) {
        val dateString = Util.getModifiedDate(results.date)
        itemView.findViewById<TextView>(R.id.race_date).text = dateString
        itemView.findViewById<TextView>(R.id.country_name).text = results.country

        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 20f
        circularProgressDrawable.start()

        Glide.with(context)
            .load(Util.getCountryFlagLink(results.country))
            .placeholder(circularProgressDrawable)
            .into(itemView.findViewById(R.id.country_flag))
    }


}
