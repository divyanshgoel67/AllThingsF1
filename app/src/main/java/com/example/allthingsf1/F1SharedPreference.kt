package com.example.allthingsf1

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Singleton

@Singleton
class F1SharedPreference {

    private var sharedPreference: SharedPreferences =
        F1Application.getContext().getSharedPreferences(preferenceName, Context.MODE_PRIVATE)

    companion object {

        private const val preferenceName = "f1_shared_preference"
        private const val DISPLAY_SEASON = "display_season"
        private const val CURRENT_SEASON = "current_season"

        @JvmStatic
        val instance: F1SharedPreference by lazy {
            F1SharedPreference()
        }
    }

    fun getDisplaySeason(): String? {
        return sharedPreference.getString(DISPLAY_SEASON, "")
    }

    fun setDisplaySeason(displaySeason: String) {
        sharedPreference.edit().putString(DISPLAY_SEASON, displaySeason)
    }

    fun getCurrentSeason(): String? {
        return sharedPreference.getString(CURRENT_SEASON, "")
    }

    fun setCurrentSeason(currentSeason: String) {
        sharedPreference.edit().putString(CURRENT_SEASON, currentSeason)
    }

}
