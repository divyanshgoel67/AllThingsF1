package com.example.allthingsf1

import com.example.allthingsf1.activity.LauncherActivity
import com.example.allthingsf1.fragment.StandingsFragment
import com.example.allthingsf1.viewmodel.RaceResultsViewModel
import com.example.f1repository.RaceResultsRepository
import com.example.f1repository.RaceScheduleRepository
import com.example.f1repository.SeasonsListRepository
import com.example.f1repository.dagger.RepositoryModule
import com.example.f1repository.dagger.StaticRepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class, StaticRepositoryModule::class])
interface RepositoryComponent {

    fun getRaceResultsRepository(): RaceResultsRepository

    fun getSeasonsListRepository(): SeasonsListRepository

    fun getRaceScheduleRepository(): RaceScheduleRepository

    fun inject(activity: LauncherActivity)

    fun inject(viewModel: RaceResultsViewModel)

    fun inject(fragment: StandingsFragment)
}
