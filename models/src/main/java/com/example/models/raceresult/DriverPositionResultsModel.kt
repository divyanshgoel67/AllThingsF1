package com.example.models.raceresult

data class DriverPositionResultsModel(
    var position: Int,
    var driverNumber: Int,
    var nationality: String,
    var constructor: String,
    var status: String,
    var raceTime: String,
    var fastestLap: String
) {
    var driver: String = ""
    var avgSpeed: String = ""
}
