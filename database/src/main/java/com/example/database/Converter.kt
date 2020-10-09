package com.example.database

import androidx.room.TypeConverter
import com.example.database.models.DriverPositionResultsModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromArrayListToString(res : ArrayList<DriverPositionResultsModel>) : String {
            return try {
                Gson().toJson(res)
            } catch (e : Exception) {
                ""
            }
        }

        @TypeConverter
        @JvmStatic
        fun fromStringToArrayList(res : String) : ArrayList<DriverPositionResultsModel> {
            return try {
                val type = object : TypeToken<ArrayList<DriverPositionResultsModel?>?>() {}.type
                Gson().fromJson(res, type)
            } catch (e : Exception) {
                ArrayList()
            }
        }
    }

}
