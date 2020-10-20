package com.example.f1repository

import android.content.Context
import com.example.f1repository.dagger.DaggerDatabaseComponent
import com.example.f1repository.dagger.DatabaseComponent
import com.example.f1repository.dagger.DatabaseModule

class RepositoryInitialiser(var context: Context) {

    private lateinit var databaseComponent: DatabaseComponent

    companion object {

        @JvmStatic
        lateinit var instance: RepositoryInitialiser

        @JvmStatic
        fun initialise(context: Context) {
            if (!::instance.isInitialized)
                instance = RepositoryInitialiser(context)
            instance.initialiseRepository()
        }

    }

    fun initialiseRepository() {
        databaseComponent =
            DaggerDatabaseComponent.builder().databaseModule(DatabaseModule(context)).build()
    }

    fun getDataBaseComponent(): DatabaseComponent {
        return databaseComponent
    }

}
