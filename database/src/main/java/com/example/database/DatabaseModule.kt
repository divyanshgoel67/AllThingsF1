package com.example.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun getDatabase(context: Context): F1Database {
        return Room.databaseBuilder(
            context.applicationContext,
            F1Database::class.java,
            "notes_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }


}
