package com.example.allthingsf1

import com.example.f1repository.SeasonsListRepository
import com.example.f1repository.dagger.StaticRepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StaticRepositoryModule::class])
interface StaticRepositoryComponent {

    fun getSeasonsListRepository(): SeasonsListRepository

    fun inject(activity: com.example.allthingsf1.activity.LauncherActivity)

}
