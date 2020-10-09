package com.example.f1repository.displaymodels

data class SeasonRaceResultsDisplayModel(
    var results: List<PerRaceResultDisplayModel>
)

data class PerRaceResultDisplayModel(
    var raceResult: List<DriverRaceDetailsDisplayModel>
)

data class DriverRaceDetailsDisplayModel(
    var pos: Int,
    var name: String,
    var time: String
)
