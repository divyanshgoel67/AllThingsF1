package com.example.allthingsf1.recyclerview

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.allthingsf1.BR
import com.example.allthingsf1.OnExpandButtonClickListener
import com.example.allthingsf1.R
import com.example.allthingsf1.Util
import com.example.allthingsf1.databinding.RaceResultsItemLayoutBinding
import com.example.models.raceresult.RaceResultsModel

class RaceResultsViewHolder(
    itemView: View,
    var itemBinding: RaceResultsItemLayoutBinding,
    var context: Context
) : RecyclerView.ViewHolder(itemView) {
    fun bind(results: RaceResultsModel) {

        itemBinding.raceResultsMotionLayout.transitionToState(R.id.contracted_view)

        var onClickListener = object : OnExpandButtonClickListener {
            override fun onClick() {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
                when (itemBinding.raceResultsMotionLayout.currentState) {
                    R.id.expanded_view -> {
                        itemBinding.raceResultsMotionLayout.transitionToState(R.id.contracted_view)
                    }
                    R.id.contracted_view -> {
                        itemBinding.raceResultsMotionLayout.transitionToState(R.id.expanded_view)
                    }
                }
            }
        }

        itemBinding.setVariable(BR.raceResult, results)
        itemBinding.setVariable(BR.emptyString, "NA")
        itemBinding.setVariable(BR.onClickListener, onClickListener)

        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 20f
        circularProgressDrawable.start()

        Glide.with(context)
            .load(Util.getCountryFlagLink(results.country))
            .placeholder(circularProgressDrawable)
            .into(itemBinding.countryFlag)

        itemView.setOnClickListener {
        }
    }
}
